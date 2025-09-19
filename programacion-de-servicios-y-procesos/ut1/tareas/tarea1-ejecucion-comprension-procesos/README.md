<div align=justify>

# Ejecución y comprensión de procesos en linux.

<div align=center>
  <img src="./img/bg-1.gif"/>
</div>
<br>

# Tabla de contenidos

- [Bloque 1: Conceptos básicos (teoría)](#bloque-1-conceptos-básicos-teoría)
- [Bloque 2: Práctica con comandos en Linux](#bloque-2-práctica-con-comandos-en-linux)
- [Bloque 3: Procesos y jerarquía](#bloque-3-procesos-y-jerarquía)


## Bloque 1: Conceptos básicos (teoría)

1. Define qué es un **proceso** y en qué se diferencia de un **programa**.

  **Respuesta**: Es la ejecución de un programa y se considera una entidad activa porque realiza las acciones especificadas en ese programa.
  Básicamente, el programa y el proceso están relacionados, pero no son lo mismo. El programa es un código guardado en un disco duro para una fase previa del proceso. El proceso es un evento de ese programa en ejecución.

  **Fuente**: [ProfessionalReview - Diferencias entre programa y proceso](https://www.profesionalreview.com/2020/06/20/cual-es-la-diferencia-entre-un-programa-y-un-proceso/)


2. Explica qué es el **kernel** y su papel en la gestión de procesos.  

  **Respuesta**: El kernel es el núcleo de un sistema operativo y, por tanto, la interfaz entre el software y el hardware. El principal cometido del kernel es el procesamiento paralelo de diferentes tareas, el multitasking. Para ello debe, por un lado, cumplir con los tiempos establecidos y, por otro, permanecer disponible para tareas adicionales. A continuación, el kernel enciende los dispositivos conectados e inicia los primeros procesos. Se cargan los servicios del sistema, se inician o detienen otros procesos y se inician los programas de usuario como la asignación de espacio de almacenamiento.

  **Fuente**: [IONOS - ¿Qué es el kernel?](https://www.ionos.es/digitalguide/servidores/know-how/que-es-el-kernel/)

3. ¿Qué son **PID** y **PPID**? Explica con un ejemplo.

  **Respuesta**: PID (*Process ID*). Es el identificador que se adjunta a un programa cuando comienza a ejecutarse, mientras que el PPID (*Process Parent ID*) representa el proceso que creó el proceso que está comprobando. Un ejemplo puede ser un proceso de un cliente de correo electrónicos con PID 7000 y un PPID de 6500, que hace referencia al generador de clientes que lo inicializó.
  
  **Fuente**: [UnixLinux - ¿Cómo encontrar el PID y el PPID de un proceso?](https://es.unixlinux.online/ix/1002029346.html)

4. Describe qué es un **cambio de contexto** y por qué es costoso.  

  **Respuesta**: Un cambio de contexto es el proceso de almacenar el estado de un proceso o subproceso, de modo que pueda restaurarse y reanudar la ejecución en un punto posterior, y luego restaurar un estado diferente previamente guardado, estado. Esto permite que múltiples procesos compartan una sola unidad central de procesamiento (CPU) y es una característica esencial de un sistema operativo multitarea.

  Suelen ser computacionalmente intensivos; cambiar de un proceso a otro requiere una cierta cantidad de tiempo para realizar la administración: guardar y cargar registros y mapas de memoria, actualizar varias tablas y listas, etc. Lo que realmente implica un cambio de contexto depende de las arquitecturas, los sistemas operativos y la cantidad de recursos compartidos.

  **Fuente**: [AcademiaLab - Cambio de contexto](https://academia-lab.com/enciclopedia/cambio-de-contexto/)


5. Explica qué es un **PCB (Process Control Block)** y qué información almacena.

  **Respuesta**: Un bloque de control de proceso (PCB), también llamado a veces descriptor de proceso, es una estructura de datos utilizada por un sistema operativo de computadora para almacenar toda la información sobre un proceso. 
  
  Cuando se crea un proceso (inicializado o instalado), el sistema operativo crea un bloque de control de proceso correspondiente, que especifica y rastrea el estado del proceso (es decir, nuevo, listo, en ejecución, en espera o finalizado). Dado que se utiliza para rastrear la información del proceso, la PCB desempeña un papel clave en el cambio de contexto. Existen tablas de estado para cada entidad relevante, como **descripciones de memoria, dispositivos de E/S, archivos y procesos.**

  **Fuente**: [AcademiaLab - Bloques de control de procesos](https://academia-lab.com/enciclopedia/bloque-de-control-de-proceso/)

6. Diferencia entre **proceso padre** y **proceso hijo**. 

  **Respuesta**: Los procesos existen en jerarquías de padre-hijo. Un proceso iniciado por un programa o mandato es un proceso padre; un proceso hijo es el producto del proceso padre. Un proceso padre puede tener varios procesos hijo, pero un proceso hijo sólo puede tener un padre.

  **Fuente**: [IBM - Procesos](https://www.ibm.com/docs/es/aix/7.2.0?topic=processes-)

7. Explica qué ocurre cuando un proceso queda **huérfano** en Linux.  

  **Respuesta**: cualquier proceso huérfano será adoptado inmediatamente por un proceso del sistema definido por la implementación: el núcleo establece el padre para este proceso. Ocurre automáticamente. En otros sistemas, el kernel finaliza inmediatamente los procesos huérfanos.

  **Fuente**: [AcademiaLab - Proceso huérfano](https://academia-lab.com/enciclopedia/proceso-huerfano/)

8. ¿Qué es un proceso **zombie**? Da un ejemplo de cómo puede ocurrir.  

  **Respuesta**: Un proceso zombi es un proceso que ha finalizado su ejecución, pero que aún permanece en la tabla de procesos del sistema. Estos procesos no realizan ninguna actividad ni consumen recursos del sistema; simplemente esperan a que el proceso padre reciba su código de salida. Una vez que se obtiene esta información, el proceso zombi se elimina del sistema.

  Si un proceso principal no recoge rápidamente el estado de finalización del proceso hijo, pueden quedar procesos zombis. Esto puede deberse a errores de programación o a una mala implementación de la aplicación.

  **Fuente**: [TecAdmin - What is the Zombie Processes in Linux?](https://tecadmin.net/linux-zombie-processes/)

<div align=center>
  <img src="./img/bg-2.webp" alt="Zombies"/>
</div>
<br>

9.  Diferencia entre **concurrencia** y **paralelismo**.

  **Respuesta**: La principal diferencia entre concurrencia y paralelismo está relacionada con la ejecución real y simultánea de las tareas. En la concurrencia, parece que las tareas se ejecutan al mismo tiempo, pero en realidad pueden no estar ejecutándose simultáneamente, principalmente en CPU de un solo núcleo. En cambio, en el paralelismo las tareas se ejecutan realmente al mismo tiempo, principalmente en CPU multinúcleo.

  **Fuente**: [StudySmarter - Concurrencia vs Paralelismo](https://www.studysmarter.es/resumenes/ciencias-de-la-computacion/programacion-de-computadoras/concurrencia-vs-paralelismo/)

10.  Explica qué es un **hilo (thread)** y en qué se diferencia de un proceso.  

  **Respuesta**: Un hilo, o también llamado subproceso, es básicamente un flujo de ejecución o una secuencia de instrucciones manejada de forma independiente. Un hilo vive dentro del contexto de un proceso y este utiliza todos sus recursos; como por ejemplo, la memoria o los registradores.

  **Fuente**: [Medium - Entendiendo los procesos, hilos y multihilos](https://medium.com/@diego.coder/entendiendo-los-procesos-hilos-y-multihilos-9423f6e40ca7)

---

## Bloque 2: Práctica con comandos en Linux

1.  Usa echo $$ para mostrar el PID del proceso actual.

2.  Usa echo $PPID para mostrar el PID del proceso padre.

3.  Ejecuta pidof systemd y explica el resultado.

4.  Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

5.  Ejecuta ps -e y explica qué significan sus columnas.

6.  Ejecuta ps -f y observa la relación entre procesos padre e hijo.

7.  Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

8.  Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

9.  Ejecuta sleep 100 en segundo plano y busca su PID con ps.

10. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.

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

</div>
