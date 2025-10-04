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

1.  Usa `echo $$` para mostrar el PID del proceso actual.

```bash
echo $$
7560
```

2.  Usa `echo $PPID` para mostrar el PID del proceso padre.

```bash
echo $PPID
7551
```

3.  Ejecuta `pidof systemd` y explica el resultado.

```bash
pidof systemd
3313
```
**Explicación:** Indica el PID del gestor de servicios `systemd` del sistema.

4.  Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

```bash
xed &
[1] 12377

pidof xed
12377
```

5.  Ejecuta ps -e y explica qué significan sus columnas.

```bash
PID TTY          TIME CMD
  1 ?        00:00:01 systemd
  2 ?        00:00:00 kthreadd
  3 ?        00:00:00 pool_workqueue_release
```
  
**Explicación:** Muestra una lista de procesos bajo 4 columnas.
- PID: ID del proceso.
- TTY: Terminal usada (si hace uso de ella).
- TIME: Tiempo de uso de procesamiento.
- CMD: Nombre del comando.

6.  Ejecuta ps -f y observa la relación entre procesos padre e hijo.

```bash
ps -f

UID          PID    PPID  C STIME TTY          TIME CMD
dam        11655   11647  0 14:47 pts/0    00:00:00 bash
dam        12377   11655  0 14:50 pts/0    00:00:00 xed
dam        15492   11655 99 15:03 pts/0    00:00:00 ps -f
```

**Explicación:** De los ejercicios anteriores, tanto el comando `xed` como `ps -f` fueron lanzados por la terminal de `bash` actual; esto se puede corroborar fijandose que los PPID de esos comandos es igual al PID de bash.

7.  Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

```bash
systemd─┬─ModemManager───3*[{ModemManager}]
        ├─NetworkManager───3*[{NetworkManager}]
        ├─VBoxSVC─┬─VirtualBoxVM───51*[{VirtualBoxVM}]
        │         └─17*[{VBoxSVC}]
        ├─VBoxXPCOMIPCD
        ├─accounts-daemon───3*[{accounts-daemon}]
        ├─agetty
        ├─apache2───5*[apache2]
        ├─at-spi2-registr───3*[{at-spi2-registr}]
        ├─avahi-daemon───avahi-daemon
        ├─blkmapd
        ├─colord───3*[{colord}]
        ├─containerd───16*[{containerd}]
        ├─containerd-shim─┬─apache2───10*[apache2]
        │                 └─11*[{containerd-shim}]
        ├─containerd-shim─┬─apache2───6*[apache2]
        │                 └─11*[{containerd-shim}]
        ├─cron
        ├─csd-printer───3*[{csd-printer}]
        ├─cups-browsed───3*[{cups-browsed}]
        ├─cupsd
        ├─dbus-daemon
        ├─dnsmasq───dnsmasq
        ├─dockerd─┬─docker-proxy───8*[{docker-proxy}]
        │         ├─docker-proxy───6*[{docker-proxy}]
        │         ├─2*[docker-proxy───7*[{docker-proxy}]]
        │         └─29*[{dockerd}]
        ├─firefox-bin─┬─Isolated Web Co───29*[{Isolated Web Co}]
        │             ├─7*[Isolated Web Co───27*[{Isolated Web Co}]]
        │             ├─Isolated Web Co───28*[{Isolated Web Co}]
        │             ├─Privileged Cont───27*[{Privileged Cont}]
        │             ├─RDD Process───11*[{RDD Process}]
        │             ├─Socket Process───5*[{Socket Process}]
        │             ├─Utility Process───4*[{Utility Process}]
        │             ├─3*[Web Content───18*[{Web Content}]]
        │             ├─WebExtensions───27*[{WebExtensions}]
        │             ├─crashhelper───{crashhelper}
        │             └─129*[{firefox-bin}]
        ├─fsidd
        ├─irqbalance───{irqbalance}
        ├─2*[kerneloops]
        ├─lightdm─┬─Xorg───11*[{Xorg}]
        │         ├─lightdm─┬─cinnamon-sessio─┬─agent───3*[{agent}]
        │         │         │                 ├─applet.py
        │         │         │                 ├─at-spi-bus-laun─┬─dbus-daemon
        │         │         │                 │                 └─4*[{at-spi-bu+
        │         │         │                 ├─blueman-applet───4*[{blueman-ap+
        │         │         │                 ├─cinnamon-killer───4*[{cinnamon-+
        │         │         │                 ├─cinnamon-launch─┬─cinnamon───25+
        │         │         │                 │                 └─6*[{cinnamon-+
        │         │         │                 ├─csd-a11y-settin───4*[{csd-a11y-+
        │         │         │                 ├─csd-automount───4*[{csd-automou+
        │         │         │                 ├─csd-background───4*[{csd-backgr+
        │         │         │                 ├─csd-clipboard───3*[{csd-clipboa+
        │         │         │                 ├─csd-color───4*[{csd-color}]
        │         │         │                 ├─csd-housekeepin───4*[{csd-house+
        │         │         │                 ├─csd-keyboard───4*[{csd-keyboard+
        │         │         │                 ├─csd-media-keys───4*[{csd-media-+
        │         │         │                 ├─csd-power───4*[{csd-power}]
        │         │         │                 ├─csd-print-notif───3*[{csd-print+
        │         │         │                 ├─csd-screensaver───3*[{csd-scree+
        │         │         │                 ├─csd-settings-re───4*[{csd-setti+
        │         │         │                 ├─csd-wacom───3*[{csd-wacom}]
        │         │         │                 ├─csd-xsettings───4*[{csd-xsettin+
        │         │         │                 ├─evolution-alarm───7*[{evolution+
        │         │         │                 ├─nemo-desktop───5*[{nemo-desktop+
        │         │         │                 ├─socat
        │         │         │                 ├─xapp-sn-watcher───4*[{xapp-sn-w+
        │         │         │                 └─4*[{cinnamon-sessio}]
        │         │         └─3*[{lightdm}]
        │         └─3*[{lightdm}]
        ├─mintUpdate───8*[{mintUpdate}]
        ├─mintreport-tray───4*[{mintreport-tray}]
        ├─nfsdcld
        ├─polkitd───3*[{polkitd}]
        ├─power-profiles-───3*[{power-profiles-}]
        ├─prometheus-node───5*[{prometheus-node}]
        ├─rpc.idmapd
        ├─rpc.mountd
        ├─rpc.statd
        ├─rpcbind
        ├─rsyslogd───3*[{rsyslogd}]
        ├─rtkit-daemon───2*[{rtkit-daemon}]
        ├─smartd
        ├─socat
        ├─switcheroo-cont───3*[{switcheroo-cont}]
        ├─systemd─┬─(sd-pam)
        │         ├─chrome_crashpad───2*[{chrome_crashpad}]
        │         ├─code─┬─code───code───22*[{code}]
        │         │      ├─code───code─┬─code───19*[{code}]
        │         │      │             └─code───20*[{code}]
        │         │      ├─code───14*[{code}]
        │         │      ├─code───15*[{code}]
        │         │      ├─2*[code───17*[{code}]]
        │         │      ├─code─┬─2*[code───7*[{code}]]
        │         │      │      └─16*[{code}]
        │         │      ├─code─┬─bash───docker─┬─docker-compose───14*[{docker-+
        │         │      │      │               └─11*[{docker}]
        │         │      │      └─16*[{code}]
        │         │      ├─code─┬─5*[code───7*[{code}]]
        │         │      │      ├─devsense.php.ls───11*[{devsense.php.ls}]
        │         │      │      ├─docker───10*[{docker}]
        │         │      │      ├─intelliphp.ls───18*[{intelliphp.ls}]
        │         │      │      └─16*[{code}]
        │         │      └─38*[{code}]
        │         ├─dbus-daemon
        │         ├─dconf-service───3*[{dconf-service}]
        │         ├─evolution-addre───6*[{evolution-addre}]
        │         ├─evolution-calen───9*[{evolution-calen}]
        │         ├─evolution-sourc───4*[{evolution-sourc}]
        │         ├─gnome-keyring-d───4*[{gnome-keyring-d}]
        │         ├─gnome-terminal-─┬─bash─┬─pstree
        │         │                 │      └─xed───5*[{xed}]
        │         │                 └─5*[{gnome-terminal-}]
        │         ├─goa-daemon───4*[{goa-daemon}]
        │         ├─goa-identity-se───3*[{goa-identity-se}]
        │         ├─gvfs-afc-volume───4*[{gvfs-afc-volume}]
        │         ├─gvfs-goa-volume───3*[{gvfs-goa-volume}]
        │         ├─gvfs-gphoto2-vo───3*[{gvfs-gphoto2-vo}]
        │         ├─gvfs-mtp-volume───3*[{gvfs-mtp-volume}]
        │         ├─gvfs-udisks2-vo───4*[{gvfs-udisks2-vo}]
        │         ├─gvfsd─┬─gvfsd-trash───4*[{gvfsd-trash}]
        │         │       └─3*[{gvfsd}]
        │         ├─gvfsd-fuse───6*[{gvfsd-fuse}]
        │         ├─gvfsd-metadata───3*[{gvfsd-metadata}]
        │         ├─obexd
        │         ├─2*[pipewire───2*[{pipewire}]]
        │         ├─pipewire-pulse───2*[{pipewire-pulse}]
        │         ├─powerline-daemo
        │         ├─speech-dispatch─┬─sd_dummy───2*[{sd_dummy}]
        │         │                 ├─sd_espeak-ng───{sd_espeak-ng}
        │         │                 ├─sd_espeak-ng-mb
        │         │                 ├─sd_openjtalk
        │         │                 └─4*[{speech-dispatch}]
        │         ├─wireplumber───5*[{wireplumber}]
        │         ├─xdg-desktop-por───6*[{xdg-desktop-por}]
        │         ├─2*[xdg-desktop-por───4*[{xdg-desktop-por}]]
        │         ├─xdg-document-po─┬─fusermount3
        │         │                 └─6*[{xdg-document-po}]
        │         └─xdg-permission-───3*[{xdg-permission-}]
        ├─systemd-journal
        ├─systemd-logind
        ├─systemd-machine
        ├─systemd-resolve
        ├─systemd-timesyn───{systemd-timesyn}
        ├─systemd-udevd
        ├─touchegg───3*[{touchegg}]
        ├─udisksd───5*[{udisksd}]
        ├─upowerd───3*[{upowerd}]
        ├─virtlockd
        ├─virtlogd
        ├─winbindd───wb[A108PC11]
        ├─wpa_supplicant
        └─zed───2*[{zed}]
```

8.  Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

```bash
PID USUARIO   PR  NI    VIRT    RES    SHR S  %CPU  %MEM     HORA+ ORDEN    
4106 dam       20   0   11,6g 754492 301172 S   9,6   2,3   1:35.44 firefox+
```

9.  Ejecuta sleep 100 en segundo plano y busca su PID con ps.

```bash
sleep 100 &
[2] 16351

ps
  PID TTY          TIME CMD
11655 pts/0    00:00:00 bash
12377 pts/0    00:00:00 xed
16351 pts/0    00:00:00 sleep
16548 pts/0    00:00:00 ps
```

El comando `sleep` tiene de PID 16351 (también lo indica su ejecución en segundo plano).

10. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.

```bash
ps
  PID TTY          TIME CMD
11655 pts/0    00:00:00 bash
12377 pts/0    00:00:00 xed
16351 pts/0    00:00:00 sleep
16767 pts/0    00:00:00 ps

kill 16351
[2]+  Terminado               sleep 100

ps
  PID TTY          TIME CMD
11655 pts/0    00:00:00 bash
12377 pts/0    00:00:00 xed
16780 pts/0    00:00:00 ps
```

## Bloque 3: Procesos y jerarquía

1. Identifica el **PID del proceso init/systemd** y explica su función.

```bash
ps -e
PID TTY          TIME CMD
1 ?        00:00:01 systemd
```

Con `ps -e` podemos comprobar que el proceso `systemd` tiene el PID. Este proceso es el primero que se ejecuta por el kernel después de la carga del sistema y es el encargado de inicializar y gestionar el resto de procesos y servicios.

2. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.

Como se explicó antes: el proceso se convierte en un proceso huérfano, siendo *adoptado* por el proceso `systemd` y luego enviado a ser hijo de otro proceso padre de forma automática. En otros sistemas, el kernel puede eliminar inmediatamente estos procesos huérfanos.

3.  Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.

Si tomamos una terminal de bash y ejecutamos varios procesos desde allí, estos pasan a ser hijos del proceso de bash. Esto se puede mirar usando `ps`:

```bash
ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
dam        11655   11647  0 14:47 pts/0    00:00:00 bash
dam        18997   11655  0 15:17 pts/0    00:00:00 bash
dam        19174   18997  0 15:17 pts/0    00:00:00 xeyes
dam        19182   18997  0 15:17 pts/0    00:00:00 xed
dam        19197   18997  0 15:17 pts/0    00:00:00 top
dam        19901   18997 99 15:18 pts/0    00:00:00 ps -f
```

Pero se puede ver de una forma más clara con `pstree $$` (aunque no se especifican los PID/PPID):

```bash
pstree $$
bash─┬─pstree
     ├─top
     ├─xed───5*[{xed}]
     └─xeyes
```

4.  Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.

```bash
jobs
[1]+  Detenido                php

fg
```

Con `jobs` comprobamos que la terminal de php está detenida.

5.  Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.
  
```bash
xeyes &
[1] 21988

jobs
[1]+  Ejecutando              xeyes &
```

6.  Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.

- Running: es un proceso activo.
- Sleeping: es un proceso que está esperando que se active un evento o termine una operación.
- Zombie: un proceso *zombie*, mal finalizado. No consume memoria o cpu pero indica una mala ejecución del proceso padre.
- Stopped: un proceso que no tiene ningún tipo de procesamiento activo por parte del kernel.

7.  Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.

```bash
ps -eo pid,ppid,stat,cmd
    PID    PPID STAT CMD
      1       0 Ss   /sbin/init splash
      2       0 S    [kthreadd]
      3       2 S    [pool_workqueue_release]
```

8.  Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.

Lo que hace `watch` es ejecutar `ps -e` cada segundo.

9.  Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.

Que `nohup` captura las señales *hangup*, cosa que `&` no realiza. Este señal es enviada una vez se cierra la shell donde se ejecutó.

10. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.

```bash
ulimit -a
real-time non-blocking time  (microseconds, -R) unlimited
core file size              (blocks, -c) 0
data seg size               (kbytes, -d) unlimited
scheduling priority                 (-e) 0
file size                   (blocks, -f) unlimited
pending signals                     (-i) 125404
max locked memory           (kbytes, -l) 4026016
max memory size             (kbytes, -m) unlimited
open files                          (-n) 1024
pipe size                (512 bytes, -p) 8
POSIX message queues         (bytes, -q) 819200
real-time priority                  (-r) 0
stack size                  (kbytes, -s) 8192
cpu time                   (seconds, -t) unlimited
max user processes                  (-u) 125404
virtual memory              (kbytes, -v) unlimited
file locks                          (-x) unlimited
```

<div align=center>
  <img src="./img/bg-3.gif">
</div>

</div>
