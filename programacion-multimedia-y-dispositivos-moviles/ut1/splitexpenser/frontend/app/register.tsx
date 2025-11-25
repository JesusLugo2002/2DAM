import { useRouter } from "expo-router";
import React, { useContext, useState } from "react";
import { Button, Text, TextInput, View } from "react-native";
import { AuthContext } from "../context/AuthContext";

export default function Register() {
  const { register } = useContext(AuthContext);
  const router = useRouter();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleRegister = async () => {
    const res = await register(username, password);
    if (res.ok) {
      router.replace("/login");
    } else {
      setError(res.msg || "Error al registrar");
    }
  };

  return (
    <View style={{ flex: 1, justifyContent: "center", padding: 20 }}>
      <TextInput
        placeholder="Usuario"
        value={username}
        onChangeText={setUsername}
        style={{ borderWidth: 1, marginBottom: 10, padding: 8 }}
      />
      <TextInput
        placeholder="Contraseña"
        value={password}
        onChangeText={setPassword}
        secureTextEntry
        style={{ borderWidth: 1, marginBottom: 10, padding: 8 }}
      />
      {error ? <Text style={{ color: "red" }}>{error}</Text> : null}
      <Button title="Registrar" onPress={handleRegister} />
      <Button title="Volver al login" onPress={() => router.push("/login")} />
    </View>
  );
}
