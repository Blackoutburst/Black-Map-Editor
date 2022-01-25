[![License](https://img.shields.io/github/license/Blackoutburst/Black-Map-Editor.svg)](LICENSE)
[<img src="https://img.shields.io/badge/Webpage-B.M.E-blueviolet">](https://www.blackoutburst.com/bme.html)

# Black Map Editor

Blackoutburst map editor a.k.a B.M.E is a simple map editor for 2D map creation, you can add any texture you want for tiles and same for skybox (skybox are only used for render)
You can toggle option like draging to place / remove element.

## Features
- Toggle Grid
- Toggle tile/ light hitbox (Blue hitbox non solide tile, red hitbox solide tile, green hitbox light)
- Toggle more information such as FPS, tile number, hovered tile information, texture position, ...
- Toggle tile solidity
- Toggle Drag mode (make you able to place multiple block while draging you mouse arround)
- Export map
- Load map
- Toggle tile pannel (add new tiles inside the folder)
- Toggle skybox pannel (add new skybox inside the folder)
- Toggle light, make you place light instead of tiles
- Real times shadow for solid tiles
- Dynamic lightning
- Light color and size customisation
- Tiles size and rotation customisation

## How to build
Clone this project inside Eclipse IDE and build it with Eclipse

## How to load a map made with this editor
Map file are generated in a .dat enxtension file but are encoder in utf-8
##### A map file contain two type of line :
- Block line
- Light line

##### Exemple :
- B 100 50 40 40 true 90 rock
- L 25 70 1 0 1 5

##### Format
- **char**(object type) **float**(position X)  **float**(position Y) **float**(width) **float**(height) **boolean**(solid or not) **float**(rotation) **String**(texture name)
- **char**(object type) **float**(position X)  **float**(position Y) **float**(red value) **float**(green value) **float**(blue value) **float**(scale)

## Screenshot
![screen1](/screen1.png)
![screen2](/screen2.png)
![screen1](/screen3.png)

 ## Exemple of project where i used B.M.E
- [My Runner](https://github.com/Blackoutburst/My-Runner)
- [My Defender](https://github.com/Blackoutburst/My_Defender)
- [Falling Square](https://github.com/Blackoutburst/FallingSquare)
