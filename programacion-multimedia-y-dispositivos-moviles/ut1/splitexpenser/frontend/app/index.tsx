import { useRouter } from "expo-router";
import React, { useContext, useEffect, useState } from "react";
import { Button, Text, TextInput, View } from "react-native";
import { AuthContext } from "../context/AuthContext";

export default function Home() {
  const { token, logout } = useContext(AuthContext);
  const router = useRouter();
  const [groups, setGroups] = useState(["Grupo1", "Grupo2"]);

  useEffect(() => {
    if (!token) {
      setTimeout(() => router.replace("/login"), 0);
    }
  }, [token]);

  if (!token) return null;

  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
      <Text>Sus Grupos</Text>
      <TextInput placeholder="Agregue su grupo"></TextInput>
      <Button title="Registrar"></Button>
      {groups.map((e) => (
        <View key={e}>
          <Text onPress={() => router.replace("/groupdetail")}>{e}</Text>
        </View>
      ))}
      <Button title="Cerrar sesión" onPress={() => void logout()} />
    </View>
  );
}
