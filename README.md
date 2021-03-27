# Eolia Minecraft Plugin

## Description
Minecraft server plugin projet
## Installation
Open the project on your IDE and launch the mvn package command.
Take your jar file (in the target folder) and put it on your server via FTP in the plugins folder.
## Commands
- /test : Give a stack of dirt to the player
## Events
- Break item : When the player broke an item, he receive one message
- onHarvest : When a farmer harvest a block of dirt he receive money. *Needs Essentials Plugin*
- onBlockBreak : When a player break a block he receive money if the block is linked to his job. *Needs Essentials Plugin* 
