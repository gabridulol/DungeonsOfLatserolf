package DungeonsOfLatserolf.input;

import DungeonsOfLatserolf.entity.player.PlayerEntity;
import DungeonsOfLatserolf.map.MapEntity;

// + movePlayer(mapEntilyl:MapEntily, playerEntily:PlayerEntily): void

// + openTile(mapEntily:MapEntily, playerEntily:PlayerEntily): void

// + keyPressed(e:KeyEvent): char

// + keyTyped (e KeyEvent): void



public class Display {
    public void movePlayer(MapEntity mapDungeon, PlayerEntity player){
        char key = keyPressed();
        
        // switch (key) {
        //     case 'E':
        //         if ()
                
        //         break;
        
        //     default:
        //         break;
        // }
    }

    public void openTile(MapEntity mapDungeon, PlayerEntity player){
        
    }

    public char keyPressed(){
        return 'a';
    }
    

}
