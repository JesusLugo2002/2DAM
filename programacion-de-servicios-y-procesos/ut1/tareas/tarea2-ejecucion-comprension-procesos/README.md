# Ejecución y comprensión de procesos

- [Preparación](#preparación)
- [Bloque 1 — Conceptos (breve + fuentes)](#bloque-1--conceptos-breve--fuentes)
- [Bloque 2 — Práctica guiada (todo en tu `$DAM`)](#bloque-2--práctica-guiada-todo-en-tu-dam)
  - [2.1 — PIDs básicos](#21--pids-básicos)
  - [2.2 — Servicios **de usuario** con systemd](#22--servicios-de-usuario-con-systemd)
  - [2.3 — Observación de procesos sin root](#23--observación-de-procesos-sin-root)
  - [2.4 — Estados y jerarquía (sin root)](#24--estados-y-jerarquía-sin-root)
  - [25 — Limpieza (solo tu usuario)](#25--limpieza-solo-tu-usuario)
- [¿Qué estás prácticando?](#qué-estás-prácticando)


## Preparación

Crea tu área de trabajo y variables útiles:

```bash
mkdir -p ~/dam/{bin,logs,units}
export DAM=~/dam
echo 'export DAM=~/dam' >> ~/.bashrc
```

Comprobar versión de systemd y que el *user manager* está activo:

```bash
systemctl --user --version | head -n1
systemctl --user status --no-pager | head -n5
```
**Pega salida aquí:**

```text
systemctl --user --version | head -n1
systemd 255 (255.4-1ubuntu8.6)

systemctl --user status --no-pager | head -n5
● a108pc11
    State: running
    Units: 262 loaded (incl. loaded aliases)
     Jobs: 0 queued
   Failed: 0 units
```

**Reflexiona la salida:**

```text
Con el primer comando se comprueba que la versión de systemd es la 255 (específicamente, 255.4-1ubuntu8.6).

Con el segundo comando, comprobamos el estado del gestor de servicios del usuario (gracias al --user). 
```

---

## Bloque 1 — Conceptos (breve + fuentes)

1) ¿Qué es **systemd** y en qué se diferencia de SysV init?  

**Respuesta:** `systemd` es el gestor de servicios del sistema. Encargado de inicializar los servicios del sistema cuando es arrancado y unificar todo el sistema en un proceso inicial con PID 1.

_Fuentes:_ [System and Service Manager](https://systemd.io/)

2) **Servicio** vs **proceso** (ejemplos).  

**Respuesta:** Los procesos son instancias individuales de un programa que está ejecutándose en el sistema, mientras que los servicios son procesos que se ejecutan en segundo plano y proveen distintas funciones al sistema. Un ejemplo de ellos puede ser el proceso `bash` que apunta a una terminal de bash en ejecución, mientras que un servicio `httpd` es el encargado de desplegar un servidor web.

_Fuentes:_ [Working with processes and services](https://tecadmin.net/working-with-processes-and-services-in-linux-a-beginners-guide/)

3) ¿Qué son los **cgroups** y para qué sirven?  

**Respuesta:** Los *cgroups* o grupos de control son una función del kernel que permiten limitar, contabilizar y aislar el uso de recursos del sistema para un conjunto de procesos. 

_Fuentes:_ [Introduction to Control Groups - Red Hat Documentation](https://docs.redhat.com/en/documentation/red_hat_enterprise_linux/6/html/resource_management_guide/ch01)

4) ¿Qué es un **unit file** y tipos (`service`, `timer`, `socket`, `target`)?  

**Respuesta:** son la representación estandarizada de los recursos del sistema que pueden ser gestionado por el conjunto de servicios y manipulados por otros servicios proporcionados. Hay de varios tipos:
  - Service: describen la forma de gestionar un servicio o aplicación en el servidor.
  - Timer: define un temporizador que será gestionado por `systemd`, similar al `cron` utilizado para retrasar las rutinas de activación.
  - Socket: describe una red o un socket Unix para utilizar el sistema de ficheros como dirección de espacios de nombres; lo que los procesos toman como archivos de un sistema de archivos.
  - Target: utilizado para proveer puntos de sincronización a otras unidades cuando se está arrancando el sistema o se cambia de estados.

_Fuentes:_ [Understanding Systemd Units and Unit Files](https://www.digitalocean.com/community/tutorials/understanding-systemd-units-and-unit-files)

5) ¿Qué hace `journalctl` y cómo ver logs **de usuario**?  

**Respuesta:** Es el servicio encargado de centralizar la administración de  registros del `systemd`. Los registros suelen estar dispersos por todo el sistema, cuando hablamos de otros sistemas operativos, pero en Linux, `journalctl` se encarga de centralizar todo este proceso, gestionando todos los registros producidos por el kernel, `initrd`, otros servicios y demás.

Con distintas opciones podemos ver los registros. El comando simple `journalctl` muestra una lista, siendo las de arriba las más antigüas. Pero por ejemplo, con la opción `--utc` podemos mostrar las marcas de tiempo en hora UTC. 

_Fuentes:_ [Cómo usar Journalctl para ver y manipular los registros de Systemd](https://www.digitalocean.com/community/tutorials/how-to-use-journalctl-to-view-and-manipulate-systemd-logs-es)

---

## Bloque 2 — Práctica guiada (todo en tu `$DAM`)

> Si un comando pide permisos que no tienes, usa la **versión `--user`** o consulta el **ayuda** con `--help` para alternativas.

### 2.1 — PIDs básicos

**11.** PID de tu shell y su PPID.

```bash
echo "PID=$$  PPID=$PPID"
```
**Salida:**

```text
PID=40477  PPID=40468
```

**Pregunta:** ¿Qué proceso es el padre (PPID) de tu shell ahora?  

**Respuesta:** El 40468.

---

**12.** PID del `systemd` (manager de usuario) y explicación.

```bash
pidof systemd || pgrep -u "$USER" -x systemd
```

**Salida:**

```text
3323
```

**Pregunta:** ¿Qué hace el *user manager* de systemd para tu sesión?  

**Respuesta:** Es una instancia del `systemd` responsable del lanzamiento y la gestión de procesos y servicios del usuario específico.

---

### 2.2 — Servicios **de usuario** con systemd

Vamos a crear un servicio sencillo y un timer **en tu carpeta** `~/.config/systemd/user` o en `$DAM/units` (usaremos la primera para que `systemctl --user` lo encuentre).

**13.** Prepara directorios y script de práctica.

```bash
mkdir -p ~/.config/systemd/user "$DAM"/{bin,logs}
cat << 'EOF' > "$DAM/bin/fecha_log.sh"
#!/usr/bin/env bash
mkdir -p "$HOME/dam/logs"
echo "$(date --iso-8601=seconds) :: hello from user timer" >> "$HOME/dam/logs/fecha.log"
EOF
chmod +x "$DAM/bin/fecha_log.sh"
```

**14.** Crea el servicio **de usuario** `fecha-log.service` (**Type=simple**, ejecuta tu script).

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.service
[Unit]
Description=Escribe fecha en $HOME/dam/logs/fecha.log

[Service]
Type=simple
ExecStart=%h/dam/bin/fecha_log.sh
EOF

systemctl --user daemon-reload
systemctl --user start fecha-log.service
systemctl --user status fecha-log.service --no-pager -l | sed -n '1,10p'
```
**Salida (pega un extracto):**

```text
○ fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log
     Loaded: loaded (/home/dam/.config/systemd/user/fecha-log.service; static)
     Active: inactive (dead)

sep 23 19:55:23 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
```

**Pregunta:** ¿Se creó/actualizó `~/dam/logs/fecha.log`? Muestra las últimas líneas:

```bash
tail -n 5 "$DAM/logs/fecha.log"
```

**Salida:**

```text
2025-09-23T19:55:23+01:00 :: hello from user timer
```

**Reflexiona la salida:**

```text
El servicio ha funcionado y lanzado el script que tiene configurado: ha añadido un log con la fecha y hora actual.
```

---

**15.** Diferencia **enable** vs **start** (modo usuario). Habilita el **timer**.

```bash
cat << 'EOF' > ~/.config/systemd/user/fecha-log.timer
[Unit]
Description=Timer (usuario): ejecuta fecha-log.service cada minuto

[Timer]
OnCalendar=*:0/1
Unit=fecha-log.service
Persistent=true

[Install]
WantedBy=timers.target
EOF

systemctl --user daemon-reload
systemctl --user enable --now fecha-log.timer
systemctl --user list-timers --all | grep fecha-log || true
```

**Salida (recorta):**

```text
systemctl --user daemon-reload

systemctl --user enable --now fecha-log.timer
Created symlink /home/dam/.config/systemd/user/timers.target.wants/fecha-log.timer → /home/dam/.config/systemd/user/fecha-log.timer.

systemctl --user list-timers --all | grep fecha-log || true
Tue 2025-09-23 19:59:00 WEST  45s -                                       - fecha-log.timer                fecha-log.service

```
**Pregunta:** ¿Qué diferencia hay entre `enable` y `start` cuando usas `systemctl --user`?  

**Respuesta:** `enable` crea un `symlink` del servicio para que este se ejecute al arrancar el sistema, mientras que `start` lo ejecuta al instante.

---

**16.** Logs recientes **del servicio de usuario** con `journalctl --user`.

```bash
journalctl --user -u fecha-log.service -n 10 --no-pager
```

**Salida:**

```text
sep 23 19:55:23 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 19:55:56 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 19:59:04 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:00:46 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:01:46 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:02:46 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:03:46 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:04:46 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:05:17 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
sep 23 20:06:20 a108pc11 systemd[3276]: Started fecha-log.service - Escribe fecha en $HOME/dam/logs/fecha.log.
```
**Pregunta:** ¿Ves ejecuciones activadas por el timer? ¿Cuándo fue la última?  

**Respuesta:** Todas las últimas ejecuciones fueron activadas por el timer.

---

### 2.3 — Observación de procesos sin root

**17.** Puertos en escucha (lo que puedas ver como usuario).

```bash
lsof -i -P -n | grep LISTEN || ss -lntp
```
**Salida:**

```text
State    Recv-Q   Send-Q     Local Address:Port     Peer Address:Port  Process  
LISTEN   0        4096          127.0.0.54:53            0.0.0.0:*              
LISTEN   0        4096       127.0.0.53%lo:53            0.0.0.0:*              
LISTEN   0        4096           127.0.0.1:631           0.0.0.0:*              
LISTEN   0        4096               [::1]:631              [::]:*           
```

**Pregunta:** ¿Qué procesos *tuyos* están escuchando? (si no hay, explica por qué)  

**Respuesta:** No hay procesos *mios* porque en la columna de *Process* no aparece nada de información sobre usuarios que hayan lanzado el proceso.

---

**18.** Ejecuta un proceso bajo **cgroup de usuario** con límite de memoria.

```bash
systemd-run --user --scope -p MemoryMax=50M sleep 200 &
ps -eo pid,ppid,cmd,stat | grep "[s]leep 200"
```

**Salida:**

```text
systemd-run --user --scope -p MemoryMax=50M sleep 200 &
Running as unit: run-ra0f92797da66486e8cc22069378b6021.scope; invocation ID: 836cc9fc40cf480e96eefa23e93a45e7

ps -eo pid,ppid,cmd,stat | grep "[s]leep 200"
   4013    3409 /usr/bin/sleep 200          S
```

**Pregunta:** ¿Qué ventaja tiene lanzar con `systemd-run --user` respecto a ejecutarlo “a pelo”?  

**Respuesta:** Que la ejecución pasa a través del gestor de servicios y permite algunas características como visualizarlo en el *output* de `systemctl list-units` como cualquier otro servicio.

---

**19.** Observa CPU en tiempo real con `top` (si tienes `htop`, también vale).

```bash
top -b -n 1 | head -n 15
```
**Salida (resumen):**

```text
top - 01:17:38 up 24 min,  1 user,  load average: 0,00, 0,03, 0,08
Tareas: 217 total,   1 ejecutar,  216 hibernar,    0 detener,    0 zombie
%Cpu(s):  0,0 us,  0,0 sy,  0,0 ni,100,0 id,  0,0 wa,  0,0 hi,  0,0 si,  0,0 st 
MiB Mem :   7941,9 total,   5984,2 libre,   1017,0 usado,   1207,8 búf/caché    
MiB Intercambio:   3898,0 total,   3898,0 libre,      0,0 usado.   6924,9 dispon

    PID USUARIO   PR  NI    VIRT    RES    SHR S  %CPU  %MEM     HORA+ ORDEN
   4076 dam       20   0   20192   5752   3576 R   9,1   0,1   0:00.01 top
      1 root      20   0   22544  13332   9364 S   0,0   0,2   0:02.84 systemd
      2 root      20   0       0      0      0 S   0,0   0,0   0:00.06 kthreadd
      3 root      20   0       0      0      0 S   0,0   0,0   0:00.00 pool_wo+
      4 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      5 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      6 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
      7 root       0 -20       0      0      0 I   0,0   0,0   0:00.00 kworker+
```
**Pregunta:** ¿Cuál es tu proceso con mayor `%CPU` en ese momento?  

**Respuesta:** En el momento de ejecución, el proceso con PID 4076 es el que tiene mayor `%CPU` (9.1), y es el de la orden top; el mismo comando con el que se mostró esta información.

---

**20.** Traza syscalls de **tu propio proceso** (p. ej., el `sleep` anterior).
> Nota: Sin root, no podrás adjuntarte a procesos de otros usuarios ni a algunos del sistema.

```bash
pid=$(pgrep -u "$USER" -x sleep | head -n1)
strace -p "$pid" -e trace=nanosleep -tt -c -f 2>&1 | sed -n '1,10p'
```

**Salida (fragmento):**

```text
strace: -t/--absolute-timestamps has no effect with -c/--summary-only
strace: attach: ptrace(PTRACE_SEIZE, 4178): Operación no permitida
```
**Pregunta:** Explica brevemente la syscall que observaste.  

**Respuesta:** 

---

### 2.4 — Estados y jerarquía (sin root)

**21.** Árbol de procesos con PIDs.

```bash
pstree -p | head -n 50
```

**Salida (recorta):**

```text
systemd(1)-+-ModemManager(1856)-+-{ModemManager}(1866)
           |                    |-{ModemManager}(1868)
           |                    `-{ModemManager}(1870)
           |-NetworkManager(1829)-+-{NetworkManager}(1861)
           |                      |-{NetworkManager}(1862)
           |                      `-{NetworkManager}(1863)
           |-accounts-daemon(1155)-+-{accounts-daemon}(1191)
           |                       |-{accounts-daemon}(1192)
           |                       `-{accounts-daemon}(1824)
¡
```

**Pregunta:** ¿Bajo qué proceso aparece tu `systemd --user`?  

**Respuesta:** Con `head -n 50` no puedo verlo, pero eliminando esta parte del comando, podemos comprobar que es el proceso con PID 3354. Algo que también se puede comprobar al lanzar  `pidof systemd`.

```text
├─systemd(3354)─┬─(sd-pam)(3355)
           │               ├─chrome_crashpad(48206)─┬─{chrome_crashpad}(48207)
           │               │                        └─{chrome_crashpad}(48208)
           │               ├─code(48175)─┬─code(48184)───code(48223)─┬─{code}(4+
```

---

**22.** Estados y relación PID/PPID.

```bash
ps -eo pid,ppid,stat,cmd | head -n 20
```
**Salida:**

```text
    PID    PPID STAT CMD
      1       0 Ss   /sbin/init splash
      2       0 S    [kthreadd]
      3       2 S    [pool_workqueue_release]
      4       2 I<   [kworker/R-rcu_g]
      5       2 I<   [kworker/R-rcu_p]
      6       2 I<   [kworker/R-slub_]
      7       2 I<   [kworker/R-netns]
     10       2 I<   [kworker/0:0H-events_highpri]
     12       2 I<   [kworker/R-mm_pe]
     13       2 I    [rcu_tasks_kthread]
     14       2 I    [rcu_tasks_rude_kthread]
     15       2 I    [rcu_tasks_trace_kthread]
     16       2 S    [ksoftirqd/0]
     17       2 I    [rcu_preempt]
     18       2 S    [migration/0]
     19       2 S    [idle_inject/0]
     20       2 S    [cpuhp/0]
     21       2 S    [cpuhp/1]
     22       2 S    [idle_inject/1]
```

**Pregunta:** Explica 3 flags de `STAT` que veas (ej.: `R`, `S`, `T`, `Z`, `+`).  

**Respuesta:** `S` es para los detenidos *no interruptibles*, que están esperando eventos para activarse. `Z` para los procesos *zombies* y `I` para los hilos provenientes del kernel en un estado inactivo.

---

**23.** Suspende y reanuda **uno de tus procesos** (no crítico).

```bash
# Crea un proceso propio en segundo plano
sleep 120 &
pid=$!
# Suspende
kill -STOP "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
# Reanuda
kill -CONT "$pid"
# Estado
ps -o pid,stat,cmd -p "$pid"
```
**Pega los dos estados (antes/después):**

```text
ANTES
    PID STAT CMD
  53410 T    sleep 120

DESPUES
    PID STAT CMD
  53410 S    sleep 120
```

**Pregunta:** ¿Qué flag indicó la suspensión?  

**Respuesta:** La `T` indica que fue interrumpido por una señal de control, lo que lo deja en estado de suspensión.

---

**24. (Opcional)** Genera un **zombie** controlado (no requiere root).

```bash
cat << 'EOF' > "$DAM/bin/zombie.c"
#include <stdlib.h>
#include <unistd.h>
int main() {
  if (fork() == 0) { exit(0); } // hijo termina
  sleep(60); // padre no hace wait(), hijo queda zombie hasta que padre termine
  return 0;
}
EOF
gcc "$DAM/bin/zombie.c" -o "$DAM/bin/zombie" && "$DAM/bin/zombie" &
ps -el | grep ' Z '
```
**Salida (recorta):**

```text
1 Z  1001   54926   54925  0  80   0 -     0 -      pts/0    00:00:00 zombie
```
**Pregunta:** ¿Por qué el estado `Z` y qué lo limpia finalmente?  

**Respuesta:** El estado `Z` es el indicativo de un proceso *zombie* y la forma rápida de eliminarlo es eliminando su proceso padre.

---

### 25 — Limpieza (solo tu usuario)

Detén y deshabilita tu **timer/servicio de usuario** y borra artefactos si quieres.

```bash
systemctl --user disable --now fecha-log.timer
systemctl --user stop fecha-log.service
rm -f ~/.config/systemd/user/fecha-log.{service,timer}
systemctl --user daemon-reload
rm -rf "$DAM/bin" "$DAM/logs" "$DAM/units"
```

---

## ¿Qué estás prácticando?
- [ ] Pegaste **salidas reales**.  
- [ ] Explicaste **qué significan**.  
- [ ] Usaste **systemd --user** y **journalctl --user**.  
- [ ] Probaste `systemd-run --user` con límites de memoria.  
- [ ] Practicaste señales (`STOP`/`CONT`), `pstree`, `ps` y `strace` **sobre tus procesos**.
