import { useRouter } from "expo-router";
import React, { useContext, useState } from "react";
import { Button, Text, TextInput, View, Alert } from "react-native";
import { AuthContext } from "../context/AuthContext";

export default function Login() {
  const { login, token } = useContext(AuthContext);
  const [expenses, setExpenses] = useState([
    {
      id: "e.id",
      desc: "e.description",
      amount: "e.amount",
      paid_by: "e.paid_by",
    },
  ]);
  const router = useRouter();

  const handleDelete = (id: string) => {
    console.log(`Borro el id: ${id}`);
    Alert.alert(`Voy a borrar el id: ${id}`);
    for (let index = 0; index < expenses.length; index++) {
      if (expenses[index].id === id) {
        expenses.splice(index);
        setExpenses([...expenses]);
        break;
      }      
    }
  };

  const handleEdit = () => {
    Alert.alert("Voy a edit");
  };

  return (
    <View style={{ flex: 1, justifyContent: "center", padding: 20 }}>
      <Text>Mi grupo</Text>
      {expenses.map((e) => (
        <View key={e.id}>
          <Text
            onPress={() => router.replace("/groupdetail")}
          >{`Precio: ${e.amount} - ${e.desc}`}</Text>
          <Button title="Editar" onPress={handleEdit} />
          <Button title="Borrar" onPress={() => handleDelete(e.id)} />
        </View>
      ))}

      <Button title="Volver a mis grupos" onPress={() => router.replace("/")} />
    </View>
  );
}
