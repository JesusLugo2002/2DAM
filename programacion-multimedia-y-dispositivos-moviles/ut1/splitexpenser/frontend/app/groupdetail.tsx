import { useRouter } from "expo-router";
import React, { createRef, useContext, useState } from "react";
import { Button, Text, TextInput, View, Alert, Modal } from "react-native";
import { AuthContext } from "../context/AuthContext";

export default function Login() {
  const { login, token } = useContext(AuthContext);
  const [currentExpenseId, setCurrentExpenseId] = useState<string|null>(null);
  const [newAmount, setNewAmount] = useState("0");
  const [newDescription, setNewDescription] = useState("");
  const [modalVisible, setModalVisible] = useState(false);
  const [expenses, setExpenses] = useState([
    {
      id: "1",
      desc: "e.description",
      amount: "e.amount",
      paid_by: "e.paid_by",
    },
    {
      id: "2",
      desc: "e.description",
      amount: "e.amount",
      paid_by: "e.paid_by",
    },
    {
      id: "3",
      desc: "e.description",
      amount: "e.amount",
      paid_by: "e.paid_by",
    },
  ]);
  const router = useRouter();

  const handleDelete = (id: string) => {
    for (let index = 0; index < expenses.length; index++) {
      if (expenses[index].id === id) {
        expenses.splice(index, 1);
        setExpenses([...expenses]);
        break;
      }
    }
  };

  const handleEdit = () => {
    setModalVisible(false);
    if (currentExpenseId == null) return;
    handleDelete(currentExpenseId)
    const newExpense = {
      id: currentExpenseId,
      desc: newDescription,
      amount: newAmount,
      paid_by: "e.paid_by",
    }
    const sortedExpenses = [...expenses, newExpense].sort((a, b) => Number(a.id) - Number(b.id));
    setExpenses(sortedExpenses);
  };

  const openModal = (id: string) => {
    setCurrentExpenseId(id);
    setModalVisible(true);
  }

  return (
    <View style={{ flex: 1, justifyContent: "center", padding: 20 }}>
      <Text>Mi grupo</Text>
      {expenses.map((e) => (
        <View key={e.id}>
          <Text>{`${e.id} - ${e.amount} - ${e.desc}`}</Text>
          <Button title="Actualizar" onPress={() => openModal(e.id)} />
          <Button title="Borrar" onPress={() => handleDelete(e.id)} />
        </View>
      ))}

      <Modal visible={modalVisible}>
        <Text>Editando expense #{currentExpenseId}</Text>
        <Text>Inserte cantidad:</Text>
        <TextInput value={newAmount} onChangeText={(text) => setNewAmount(text)}></TextInput>
        <Text>Inserte descripción:</Text>
        <TextInput value={newDescription} onChangeText={(text) => setNewDescription(text)}></TextInput>
        <Button title="Guardar cambios" onPress={handleEdit}/>
        <Button title="Cancelar" onPress={() => setModalVisible(false)}/>
      </Modal>

      <Button title="Volver a mis grupos" onPress={() => router.replace("/")} />
    </View>
  );
}
