<div align=justify>

# Ejecución y comprensión de procesos en linux.

- [Bloque 1: Conceptos básicos (teoría)](#bloque-1-conceptos-básicos-teoría)
- [Bloque 2: Práctica con comandos en Linux](#bloque-2-práctica-con-comandos-en-linux)
  - [Ejercicio 0 (ejemplo resuelto)](#ejercicio-0-ejemplo-resuelto)
  - [Ejercicio 0 (ejemplo resuelto)](#ejercicio-0-ejemplo-resuelto-1)
- [Bloque 3: Procesos y jerarquía](#bloque-3-procesos-y-jerarquía)
  - [Ejercicio 0 (ejemplo resuelto)](#ejercicio-0-ejemplo-resuelto-2)


## Bloque 1: Conceptos básicos (teoría)

**Respuesta**

1. Explica qué es el **kernel** y su papel en la gestión de procesos.  
2. ¿Qué son **PID** y **PPID**? Explica con un ejemplo.  
3. Describe qué es un **cambio de contexto** y por qué es costoso.  
4. Explica qué es un **PCB (Process Control Block)** y qué información almacena.  
5. Diferencia entre **proceso padre** y **proceso hijo**.  
6. Explica qué ocurre cuando un proceso queda **huérfano** en Linux.  
7. ¿Qué es un proceso **zombie**? Da un ejemplo de cómo puede ocurrir.  
8.  Diferencia entre **concurrencia** y **paralelismo**.  
9.  Explica qué es un **hilo (thread)** y en qué se diferencia de un proceso.  

---

## Bloque 2: Práctica con comandos en Linux

### Ejercicio 0 (ejemplo resuelto)  

**Pregunta:** ¿Qué comando muestra el directorio actual?  

**Resolución:**  

```bash
    pwd
```

11. Usa echo $$ para mostrar el PID del proceso actual.

12. Usa echo $PPID para mostrar el PID del proceso padre.

13. Ejecuta pidof systemd y explica el resultado.

14. Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

15. Ejecuta ps -e y explica qué significan sus columnas.

16. Ejecuta ps -f y observa la relación entre procesos padre e hijo.

17. Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

18. Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

19. Ejecuta sleep 100 en segundo plano y busca su PID con ps.

20. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.


### Ejercicio 0 (ejemplo resuelto)  

**Pregunta:** ¿Qué comando muestra el árbol de procesos en Linux?

**Resolución:**  

```bash
    pstree
```

## Bloque 3: Procesos y jerarquía

21. Identifica el **PID del proceso init/systemd** y explica su función.
22. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.
23. Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.
24. Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.
25. Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.
26. Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.
27. Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.
28. Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.
29. Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.
30. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.

###  Ejercicio 0 (ejemplo resuelto)  

**Pregunta:** ¿Qué comando muestra el árbol de procesos en Linux?

**Resolución:**  

```bash
    pstree
```

</div>