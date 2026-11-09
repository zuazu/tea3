# ⚡ ElectroMove Solutions

Una aplicació orientada a objectes desenvolupada en **Java** per a la gestió integral de **flotes de vehicles elèctrics** i **estacions de càrrega**, amb suport per al càlcul de coordenades geogràfiques i validació d'entrades per consola.

---

## 📌 Taula de Continguts
- [Descripció General](#-descripció-general)
- [Estructura del Projecte](#-estructura-del-projecte)
- [Classes i Funcionalitats](#-classes-i-funcionalitats)
- [Fórmula de Haversine](#-fórmula-de-haversine)
- [Com Executar el Projecte](#-com-executar-el-projecte)
- [Estat del Desenvolupament](#-estat-del-desenvolupament)

---

## 📖 Descripció General

**ElectroMove Solutions** és una plataforma dissenyada per controlar vehicles elèctrics (estat, autonomia, nivell de bateria i ubicació GPS) i relacionar-los amb estacions de càrrega públiques o privades.

Permet gestionar l'estat dels vehicles, monitorar els punts de càrrega disponibles segons el tipus de connector i calcular distàncies reals en quilòmetres sobre la superfície terrestre.

---

## 📁 Estructura del Projecte

El projecte s'organitza sota el paquet `com.electro_move_solutions`:

```text
com.electro_move_solutions/
├── Coordenades.java     # Gestió de latitud/longitud i càlcul de distàncies
├── Vehicle.java         # Model de vehicle elèctric i els seus estats
├── PuntCarrega.java     # Model d'estació de càrrega i connectors
├── InputUtils.java      # Utilitat per a la lectura i validació d'entrades de consola
└── ElectroMove.java     # Classe principal (Main) i control del flux de l'aplicació
```

---

## 🛠️ Classes i Funcionalitats

### 🌐 `Coordenades.java`
Representa una posició GPS a la Terra.
- **Atributs**: `latitud`, `longitud`.
- **Constants**: Radi terrestre ($R = 6371.0\text{ km}$), límits de latitud ($-90^\circ$ a $90^\circ$) i longitud ($-180^\circ$ a $180^\circ$).
- **Mètode clau**: `distancia(Coordenades c2)` — Calcula la distància en km entre dos punts GPS fent servir la fórmula de Haversine.

### 🚗 `Vehicle.java`
Representa un vehicle elèctric de la flota.
- **Atributs**: Matrícula, marca, model, percentatge de bateria, autonomia (km), estat i ubicació (`Coordenades`).
- **Estats del vehicle**:
  - `1` - `ATURAT`
  - `2` - `EN_MOVIMENT`
  - `3` - `EN_CARREGA`
- **Comptador estàtic**: Manté el registre global de vehicles gestionats (`numVehiclesGestionats`).

### 🔌 `PuntCarrega.java`
Representa una estació de càrrega per a vehicles elèctrics.
- **Atributs**: Identificador, ubicació (`Coordenades`), potència (kW), tipus de connector i estat.
- **Tipus de Connectors**:
  - `1` - `TYPE2`
  - `2` - `CCS`
  - `3` - `CHADEMO`
- **Estats de la línia**:
  - `1` - `DISPONIBLE`
  - `2` - `OCUPAT`
  - `3` - `AVARIAT`

### ⌨️ `InputUtils.java`
Eina auxiliar robusta per a la lectura segura d'entrades per teclat (`Scanner`).
- Control de tipus de dades (`readInt`, `readReal`, `readLine`).
- Supressió d'excepcions mitjançant codis d'error (`ERROR_INT`, `ERROR_REAL`).
- Validació per rangs mínims i màxims.

### 🚀 `ElectroMove.java`
Punt d'entrada de l'aplicació (`main`). Inicialitza les dades d'exemple (vehicles i punts de càrrega a Catalunya) i conté el bucle principal del menú d'opcions.

---

## 📐 Fórmula de Haversine

Per calcular la distància en quilòmetres entre dues coordenades $(\varphi_1, \lambda_1)$ i $(\varphi_2, \lambda_2)$, la classe `Coordenades` utilitza la fórmula de Haversine:

$$a = \sin^2\left(\frac{\Delta\varphi}{2}\right) + \cos(\varphi_1) \cdot \cos(\varphi_2) \cdot \sin^2\left(\frac{\Delta\lambda}{2}\right)$$

$$c = 2 \cdot \operatorname{atan2}\left(\sqrt{a}, \sqrt{1-a}\right)$$

$$d = R \cdot c$$

*On $R = 6371\text{ km}$, $\Delta\varphi = \varphi_2 - \varphi_1$, i $\Delta\lambda = \lambda_2 - \lambda_1$ en radians.*

---

## 💻 Com Executar el Projecte

1. **Requisits previs**: Tenir instal·lat Java JDK 8 o superior.
2. **Compilació**:
   ```bash
   javac -d bin com/electro_move_solutions/*.java
   ```
3. **Execució**:
   ```bash
   java -cp bin com.electro_move_solutions.ElectroMove
   ```

---

## 📝 Estat del Desenvolupament

- [x] Disseny de les classes base (`Coordenades`, `Vehicle`, `PuntCarrega`).
- [x] Mètodes de càlcul de distància GPS.
- [x] Utilitats de lectura de consola segura (`InputUtils`).
- [ ] Implementació visual del menú interactiu a `ElectroMove.java`.
- [ ] Llistat i filtre de vehicles/punts de càrrega.
- [ ] Mòdul de gestió de càrrega i noves altes.
