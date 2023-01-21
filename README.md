# OMO Semestraní projekt SmartHome 🏕


## Autoři 
* Ekaterina Gulina
* Iurii Lebedev

## Zadání práce

### Abstrakt
Vytvořit aplikaci pro virtuální simulaci inteligentního domu, kde simulujeme chod domácnosti, používáme jednotlivá zařízení domu a vyhodnocujeme využití, spotřebu, volný a pracovní čas jednotlivých osob.

### Realizované finkční požadavky 
<details><summary> Seznam </summary>

- [x] F1. Entity se kterými pracujeme je dům, okenní žaluzie, patra v domu, senzory ruzného typu, zařízení, osoby, auto, kolo, domácí zvířáta.

- [x] F2. Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. 

- [x] F3. Spotřebiče mají svojí spotřebu elektřiny v aktivním stavu při použítí, idle stavu, vypnutém stavu.

- [x] F4. Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny.

- [x] F5. Jednotlivé osoby a zvířata mohou provádět aktivity, které mají nějaký efekt na zařízení nebo jinou osobu.

- [x] F6. Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti a náhodně generují eventy.

- [x] F7. Eventy jsou přebírány a odbavovány vhodnou osobou nebo zařízením. Např. porucha zařízení -> volá se táta, který může toto zařízení opravit atd.

- [x] F8. Vygenerování reportů ve složce GeneratedReports. Josu tam reporty Eventů, konfigurace domu a Resourse report za ruzná období.

- [x] F9. Při rozbití zařízení táta zkoumá dokumentaci k zařízení, která je přístupná jako proměnná přímo v zařízení a dotahuje se až, když je potřeba.
</details>

### Realizované nefinkční požadavky 
<details><summary> Seznam </summary>

- [x] Není požadována autentizace ani autorizace.

- [x] Aplikace běží v jedné JVM.

- [x] Metody a proměnné jsou dobře schované.

- [x] Reporty jsou generovány do textového souboru.

- [x] Konfigurace domu, zařízení a obyvatel domu je nahrávána z třídy Director.

</details>

## Dokumentace projektu

### Diagramy

[Class diagram](https://gitlab.fel.cvut.cz/lebediur/omo_smarthome_b221/-/blob/main/diagrams/SmarthomeClassDiagram(NEW).png)

[UC diagram](https://gitlab.fel.cvut.cz/lebediur/omo_smarthome_b221/-/blob/main/diagrams/uc.png)

### Patterny

<details><summary>Seznam patternů</summary>

- Factory method
    - Vytváření Creatures (persons & animals), Devices a Vehicles.

- Builder
    - Vytváření domu podle zvolené uživatelem konfigurace.

- Lazy loading
    - Dokumentace ke každému zařízení se nachází přímo v samotném zařízení, ale dotahuje se až, když je potřeba.

- Observer
    - U senzorů (pří nechodě Observer generuje SensorEvent), mashineState (přo změně stavu zařízení generuje MachineEvent) a pokojů (lidí se mohou přesunovat z pokoju do pokoju).

- Iterator
    - Používá se pro generování reportů pro zařízení.

- Singleton
    - Zajišťuje, že máme pouze jednou simulaci.

- State
    - Všechna zařízení a auta mají jeden ze 4 stavů: OnState (zařízení je zapnute), OffState (zařízení je vypnute), InUseState (zařízení se používá), BrokenState (zařízení je rozbité).

- Strategy
    - Lidí a zvířata mají chování.
</details>

### Konfigurace domu

#### Minimální Konfigurace
<details><summary>Standard house</summary>

2 patra, 7 pokojů, 6 člověk, 3 zvířátka.

- Floor 0
    - Garage
        - Auto
        - Bike
        - Motobike
        - Garage Doors
        - Smoke sensor

        - Father
    - Kitchen
    	- Blind window
		- Fridge
		- Dishwasher
		- Oven
		- Amimal feeder (automatic!)
		- Toaster
		- Coffee machine
		- Smoke sensor
		- Tempreture sensor

        - Mother
    
    - Living room
        - Aquarium (automatic)
		- Router
		- Blind window
		- TV
		- Robo vacuum cleaner
		- PlayStation
		- Conditioner
		- Smoke sensor

		- Grandfather
		- cat
		- fish
    
    - Bedroom for grandparents
        - Blind window
		- TV
		- Conditioner
		- Smoke sensor

		- Grandmother
- Floor 1
    - Bedroom for adults
		- Blind window
		- TV
		- Laptop
		- Conditioner
		- Smoke sensor

		- Dog
	- Bedroom for kids
		- Blind window
		- PC
		- Conditioner
		- Smoke sensor

		- Youngsister, oldersister
	- Bathroom
		- WashingMachine
		- Druer
		- Hairdryer
		- Humidity sensor
    
<details><summary>Seznam rodiny</summary>

- Mother
- Father
- Older daughter
- Young daughter
- Grandfather
- Grandmother
</details>

<details><summary>Seznam zvířat</summary>

- Cat
- Dog
- Golden fish
</details>
</details>

#### Maximální Konfigurace
<details><summary>Big house</summary>

3 patra, 8 pokojů, 6 člověk, 5 zvířátka.

- Floor 0
	- Garage 
		- Auto
		- Bike
		- Motobike
		- garage doors
		- Smoke sensor

		- Father
	- Kitchen
		- Blind window
		- Fridge
		- Dishwasher
		- Oven
		- Amimal feeder (automatic!)
		- Toaster
		- Coffee machine
		- Smoke sensor
		- Tempreture sensor

		- Mother
	- Living room
		- Aquarium (automatic)
		- Router
		- Blind window
		- TV
		- Robo vacuum cleaner
		- PlayStation
		- Conditioner
		- Smoke sensor

		- Grandmother 1
		- cat
		- fish
- Floor 1
	- Bedroom for adults
		- Blind window
		- TV
		- Laptop
		- Conditioner
		- Smoke sensor

		- dog
	- Bathroom
		- WashingMachine
		- Druer
		- Smoke sensor
		- Hairdryer
		- Humidity sensor
- Floor 2
	- Bedroom for kids
		- Blind window
		- PC
		- Conditioner
		- Smoke sensor

		- Younger and older sister
		- dog 2
	- Bedroom for grandparents
		- Blind window
		- TV
		- Conditioner
		- Smoke sensor

		- Grandmother 2
		- cat 2
	- Bathroom
		- Hairdryer
		- Humidity sensor

<details><summary>Seznam rodiny</summary>

- Mother
- Father
- Older daughter
- Young daughter
- Grandmother 2x
</details>

<details><summary>Seznam zvířat</summary>

- Cat 2x
- Dog 2x
- Golden fish
</details>
</details>
</details>
