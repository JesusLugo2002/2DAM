import * as SecureStore from "expo-secure-store";
import Constants from "expo-constants";
import React, { createContext, useEffect, useMemo, useState } from "react";

const API_URL = Constants.expoConfig?.extra?.apiUrl ?? "";
const TOKEN_KEY = Constants.expoConfig?.extra?.tokenKey ?? "";

type AuthContextType = {
  token: string | null;
  loading: boolean;
  login: (username: string, password: string) => Promise<any>;
  register: (username: string, password: string) => Promise<any>;
  logout: () => Promise<void>;
};

export const AuthContext = createContext<AuthContextType>({
  token: null,
  loading: true,
  login: async () => ({}),
  register: async () => ({}),
  logout: async () => {},
});

export const AuthProvider = ({ children }: { children: React.ReactNode }) => {
  const [token, setToken] = useState<string | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadToken = async () => {
      const saved = await SecureStore.getItemAsync(TOKEN_KEY);
      if (saved) setToken(saved);
      setLoading(false);
    };
    loadToken();
  }, []);

  const register = async (username: string, password: string) => {
    try {
      const res = await fetch(`${API_URL}/auth/register`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
      });
      return await res.json();
    } catch (err) {
      return { ok: false, msg: "Network error" };
    }
  };

  const login = async (username: string, password: string) => {
    try {
      const res = await fetch(`${API_URL}/auth/login`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password }),
      });
      const data = await res.json();
      if (res.ok && data.access_token) {
        await SecureStore.setItemAsync(TOKEN_KEY, data.access_token);
        setToken(data.access_token);
      }
      return data;
    } catch (err) {
      return { ok: false, msg: "Network error" };
    }
  };

  const logout = async () => {
    await SecureStore.deleteItemAsync(TOKEN_KEY);
    setToken(null);
  };

  const value = useMemo(
    () => ({ token, loading, login, register, logout }),
    [token, loading],
  );

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};
