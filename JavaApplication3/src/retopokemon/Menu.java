/*
 * Clase para modelar los menus que se usan repetidamente en el main
 */
package retopokemon;

/**
 *
 * @author hca
 */
public class Menu {
    
    public Menu(){
        
    }
    
    public String colocaMenuBienvenida(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("           Bienvenido al gimnasio Pokemon, que desea hacer? \n" );
        sb.append("Ver los datos de los Pokemones que se encuentran en el gimansio.......1 \n");
        sb.append("Ver una batalla pokemon...............................................2 \n");
        sb.append("Comparar a dos pokemones..............................................3 \n");
        sb.append("Cuidar a mi propio pokemon............................................4 \n");
        sb.append("Salir del gimnasio....................................................5 \n");
        return sb.toString();
    }
    
    
    public String colocaMenuCuidadoPokemon(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("Pelear.........1 \n");
        sb.append("Entrenar.........2 \n");
        sb.append("Descansar.........3 \n");
        return sb.toString();
    }

    public String colocaSiNo(){
        StringBuilder sb;
        sb=new StringBuilder();
        sb.append("Si.........1 \n");
        sb.append("No.........2 \n");
        return sb.toString();
    }
    
    /**
     * Funcion Batalla Pokemon. Esta funcion se dedica a modelar los textos 
     * respectivos a las batallas, devolviendo un String que contenga al ganador
     * y su respectivo toString(con la finalidad de mostrar el nuevo Valor de 
     * Ataque)
     * @param poke1 Pokemon atacante
     * @param poke2 Pokemon defensor
     * @return 
     */
    public String realizaBatallaPokemon(Pokemon poke1, Pokemon poke2){
        StringBuilder sb;
        String resultadobatalla;
        sb=new StringBuilder();

        resultadobatalla=poke1.atacaPokemon(poke2);
        sb.append("   Batalla Pokemon \n");
        sb.append(poke1.getNombre()+"  VS  "+poke2.getNombre()+"\n");
        sb.append("El ganador es: \n");
        sb.append(resultadobatalla+"\n");
        sb.append(resultadobatalla+" subió sus puntos de ataque \n");
        
        if(resultadobatalla.equals(poke1.getNombre()))
            sb.append(poke1.toString()+"\n");
        else
            sb.append(poke2.toString()+"\n");
        return sb.toString();
    }
    
    
    /**
     * Funcion imagen. Esta funcion tiene por objetivo devolver la imagen de 
     * pokemones clasicos (en caso de que el Pokemon posea el mismo nombre de 
     * un Pokemon que exista). La funcion recibe un objeto de tipo Pokemon y 
     * llama a su nombre(a traves de getNombre()), a traves de comparaciones la 
     * funcion puede regresar uin String con la imagen de dicho Pokemon(o puede 
     * regresar un String "")
     * @param un Objeto de tipo Pokemon
     * @return imagen
     */
    public String imagen(Pokemon un){
    StringBuilder sb;    
    sb=new StringBuilder(); 

    if(un.getNombre().equals("Charmander"))
        sb.append("               _.--\"\"`-..\n"+ 
        "            ,'          `.\n" +
        "          ,'          __  `.\n" +
        "         /|          \" __   \\\n" +
        "        , |           / |.   .\n" +
        "        |,'          !_.'|   |\n" +
        "      ,'             '   |   |\n" +
        "     /              |`--'|   |\n" +
        "    |                `---'   |\n" +
        "     .   ,                   |                       ,\".\n" +
        "      ._     '           _'  |                    , ' \\ `\n" +
        "  `.. `.`-...___,...---\"\"    |       __,.        ,`\"   L,|\n" +
        "  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \\\n" +
        "-:..     `. `-..--_.,.<       `\"      / `.        `-/ |   .\n" +
        "  `,         \"\"\"\"'     `.              ,'         |   |  ',,\n" +
        "    `.      '            '            /          '    |'. |/\n" +
        "      `.   |              \\       _,-'           |       ''\n" +
        "        `._'               \\   '\"\\                .      |\n" +
        "           |                '     \\                `._  ,'\n" +
        "           |                 '     \\                 .'|\n" +
        "           |                 .      \\                | |\n" +
        "           |                 |       L              ,' |\n" +
        "           `                 |       |             /   '\n" +
        "            \\                |       |           ,'   /\n" +
        "          ,' \\               |  _.._ ,-..___,..-'    ,'\n" +
        "         /     .             .      `!             ,j'\n" +
        "        /       `.          /        .           .'/\n" +
        "       .          `.       /         |        _.'.'\n" +
        "        `.          7`'---'          |------\"'_.'\n" +
        "       _,.`,_     _'                ,''-----\"'\n" +
        "   _,-_    '       `.     .'      ,\\\n" +
        "   -\" /`.         _,'     | _  _  _.|\n" +
        "    \"\"--'---\"\"\"\"\"'        `' '! |! /\n" +
        "                            `\" \" -' ");
    else
        if(un.getNombre().equals("Bulbasour"))
            sb.append("                                           /\n" +
                "                        _,.------....___,.' ',.-.\n" +
                "                     ,-'          _,.--\"        |\n" +
                "                   ,'         _.-'              .\n" +
                "                  /   ,     ,'                   `\n" +
                "                 .   /     /                     ``.\n" +
                "                 |  |     .                       \\.\\\n" +
                "       ____      |___._.  |       __               \\ `.\n" +
                "     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\\n" +
                "    .  ,            __               `              |   .\n" +
                "    `,'         ,-\"'  .               \\             |    L\n" +
                "   ,'          '    _.'                -._          /    |\n" +
                "  ,`-.    ,\".   `--'                      >.      ,'     |\n" +
                " . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'\n" +
                " ||:, .           ,'  ;  /  / \\ `        `.    .      .'/\n" +
                " j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /\n" +
                "/ L:_  |                 .  \"' :_;                `.'.'\n" +
                ".    \"\"'                  \"\"\"\"\"'                    V\n" +
                " `.                                 .    `.   _,..  `\n" +
                "   `,_   .    .                _,-'/    .. `,'   __  `\n" +
                "    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .\n" +
                "   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |\n" +
                "  .   _  `\"\"'--.._____..--\"   ,             '         |\n" +
                "  | .\" `. `-.                /-.           /          ,\n" +
                "  | `._.'    `,_            ;  /         ,'          .\n" +
                " .'          /| `-.        . ,'         ,           ,\n" +
                " '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'\n" +
                " `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--' ");
        else
            if(un.getNombre().equals("Squirtle"))
                sb.append("               ,........__\n" +
                    "            ,-'            \"`-.\n" +
                    "          ,'                   `-.\n" +
                    "        ,'                        \\\n" +
                    "      ,'                           .\n" +
                    "      .'\\               ,\"\".       `\n" +
                    "     ._.'|             / |  `       \\\n" +
                    "     |   |            `-.'  ||       `.\n" +
                    "     |   |            '-._,'||       | \\\n" +
                    "     .`.,'             `..,'.'       , |`-.\n" +
                    "     l                       .'`.  _/  |   `.\n" +
                    "     `-.._'-   ,          _ _'   -\" \\  .     `\n" +
                    "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n" +
                    ".'        `\"-..___      __,'\\          \\  \\     \\\n" +
                    "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\n" +
                    "  `.          |              `.          |  .     L\n" +
                    "    `.        |`--...________.'.        j   |     |\n" +
                    "      `._    .'      |          `.     .|   ,     |\n" +
                    "         `--,\\       .            `7\"\"' |  ,      |\n" +
                    "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n" +
                    "             \\ `.     .          /      |  '      |  ,'          `.\n" +
                    "              \\  v.__  .        '       .   \\    /| /              \\\n" +
                    "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n" +
                    "                `        .        `._ ___,j.  `/ .-       ,---.     |\n" +
                    "                ,`-.      \\         .\"     `.  |/        j     `    |\n" +
                    "               /    `.     \\       /         \\ /         |     /    j\n" +
                    "              |       `-.   7-.._ .          |\"          '         /\n" +
                    "              |          `./_    `|          |            .     _,'\n" +
                    "              `.           / `----|          |-............`---'\n" +
                    "                \\          \\      |          |\n" +
                    "               ,'           )     `.         |\n" +
                    "                7____,,..--'      /          |\n" +
                    "                                  `---.__,--.'");
            else
                if(un.getNombre().equals("Wartortle"))
                    sb.append("     __                                _.--'\"7\n" +
                        "    `. `--._                        ,-'_,-  ,'\n" +
                        "     ,'  `-.`-.                   /' .'    ,|\n" +
                        "     `.     `. `-     __...___   /  /     - j\n" +
                        "       `.     `  `.-\"\"        \" .  /       /\n" +
                        "         \\     /                ` /       /\n" +
                        "          \\   /                         ,'\n" +
                        "          '._'_               ,-'       |\n" +
                        "             | \\            ,|  |   ...-'\n" +
                        "             || `         ,|_|  |   | `             _..__\n" +
                        "            /|| |          | |  |   |  \\  _,_    .-\"     `-.\n" +
                        "           | '.-'          |_|_,' __!  | /|  |  /           \\\n" +
                        "   ,-...___ .=                  ._..'  /`.| ,`,.      _,.._ |\n" +
                        "  |   |,.. \\     '  `'        ____,  ,' `--','  |    /      |\n" +
                        " ,`-..'  _)  .`-..___,---'_...._/  .'      '-...'   |      /\n" +
                        "'.__' \"\"'      `.,------'\"'      ,/            ,     `.._.' `.\n" +
                        "  `.             | `--........,-'.            .         \\     \\\n" +
                        "    `-.          .   '.,--\"\"     |           ,'\\        |      .\n" +
                        "       `.       /     |          L          ,\\  .       |  .,---.\n" +
                        "         `._   '      |           \\        /  .  L      | /   __ `.\n" +
                        "            `-.       |            `._   ,    l   .    j |   '  `. .\n" +
                        "              |       |               `\"' |  .    |   /  '      .' |\n" +
                        "              |       |                   j  |    |  /  , `.__,'   |\n" +
                        "              `.      L                 _.   `    j ,'-'           |\n" +
                        "               |`\"---..\\._______,...,--' |   |   /|'      /        j\n" +
                        "               '       |                 |   .  / |      '        /\n" +
                        "                .      .              ____L   \\'  j    -',       /\n" +
                        "               / `.     .          _,\"     \\   | /  ,-','      ,'\n" +
                        "              /    `.  ,'`-._     /         \\  i'.,'_,'      .'\n" +
                        "             .       `.      `-..'             |_,-'      _.'\n" +
                        "             |         `._      |            ''/      _,-'\n" +
                        "             |            '-..._\\             `__,.--'\n" +
                        "            ,'           ,' `-.._`.            .\n" +
                        "           `.    __      |       \"'`.          |\n" +
                        "             `-\"'  `\"\"\"\"'            7         `.\n" +
                        "                                    `---'--.,'\"`' ");
                else
                    if(un.getNombre().equals("Blastoise"))
                        sb.append("                       _\n" +
                            "            _,..-\"\"\"--' `,.-\".\n" +
                            "          ,'      __.. --',  |\n" +
                            "        _/   _.-\"' |    .' | |       ____\n" +
                            "  ,.-\"\"'    `-\"+.._|     `.' | `-..,',--.`.\n" +
                            " |   ,.                      '    j 7    l \\__\n" +
                            " |.-'                            /| |    j||  .\n" +
                            " `.                   |         / L`.`\"\"','|\\  \\\n" +
                            "   `.,----..._       ,'`\"'-.  ,'   \\ `\"\"'  | |  l\n" +
                            "     Y        `-----'       v'    ,'`,.__..' |   .\n" +
                            "      `.                   /     /   /     `.|   |\n" +
                            "        `.                /     l   j       ,^.  |L\n" +
                            "          `._            L       +. |._   .' \\|  | \\\n" +
                            "            .`--...__,..-'\"\"'-._  l L  \"\"\"    |  |  \\\n" +
                            "          .'  ,`-......L_       \\  \\ \\     _.'  ,'.  l\n" +
                            "       ,-\"`. / ,-.---.'  `.      \\  L..--\"'  _.-^.|   l\n" +
                            " .-\"\".'\"`.  Y  `._'   '    `.     | | _,.--'\"     |   |\n" +
                            "  `._'   |  |,-'|      l     `.   | |\"..          |   l\n" +
                            "  ,'.    |  |`._'      |      `.  | |_,...---\"\"\"\"\"`    L\n" +
                            " /   |   j _|-' `.     L       | j ,|              |   |\n" +
                            "`--,\"._,-+' /`---^..../._____,.L',' `.             |\\  |\n" +
                            "   |,'      L                   |     `-.          | \\j\n" +
                            "            .                    \\       `,        |  |\n" +
                            "             \\                __`.Y._      -.     j   |\n" +
                            "              \\           _.,'       `._     \\    |  j\n" +
                            "              ,-\"`-----\"\"\"\"'           |`.    \\  7   |\n" +
                            "             /  `.        '            |  \\    \\ /   |\n" +
                            "            |     `      /             |   \\    Y    |\n" +
                            "            |      \\    .             ,'    |   L_.-')\n" +
                            "             L      `.  |            /      ]     _.-^._\n" +
                            "              \\   ,'  `-7         ,-'      / |  ,'      `-._\n" +
                            "             _,`._       `.   _,-'        ,',^.-            `.\n" +
                            "          ,-'     v....  _.`\"',          _:'--....._______,.-'\n" +
                            "        ._______./     /',,-'\"'`'--.  ,-'  `.\n" +
                            "                 \"\"\"\"\"`.,'         _\\`----...'");
                    else
                        if(un.getNombre().equals("Charmeleon"))
                            sb.append("                      ,-'`\\\n" +
                                "                 _,\"'    j\n" +
                                "           __....+       /               .\n" +
                                "       ,-'\"             /               ; `-._.'.\n" +
                                "      /                (              ,'       .'\n" +
                                "     |            _.    \\             \\   ---._ `-.\n" +
                                "     ,|    ,   _.'  Y    \\             `- ,'   \\   `.`.\n" +
                                "     l'    \\ ,'._,\\ `.    .              /       ,--. l\n" +
                                "  .,-        `._  |  |    |              \\       _   l .\n" +
                                " /              `\"--'    /              .'       ``. |  )\n" +
                                ".\\    ,                 |                .        \\ `. '\n" +
                                "`.                .     |                '._  __   ;. \\'\n" +
                                "  `-..--------...'       \\                  `'  `-\"'.  \\\n" +
                                "      `......___          `._                        |  \\\n" +
                                "               /`            `..                     |   .\n" +
                                "              /|                `-.                  |    L\n" +
                                "             / |               \\   `._               .    |\n" +
                                "           ,'  |,-\"-.   .       .     `.            /     |\n" +
                                "         ,'    |     '   \\      |       `.         /      |\n" +
                                "       ,'     /|       \\  .     |         .       /       |\n" +
                                "     ,'      / |        \\  .    +          \\    ,'       .'\n" +
                                "    .       .  |         \\ |     \\          \\_,'        / j\n" +
                                "    |       |  L          `|      .          `        ,' '\n" +
                                "    |    _. |   \\          /      |           .     .' ,'\n" +
                                "    |   /  `|    \\        .       |  /        |   ,' .'\n" +
                                "    |   ,-..\\     -.     ,        | /         |,.' ,'\n" +
                                "    `. |___,`    /  `.   /`.       '          |  .'\n" +
                                "      '-`-'     j     ` /.\"7-..../|          ,`-'\n" +
                                "                |        .'  / _/_|          .\n" +
                                "                `,       `\"'/\"'    \\          `.\n" +
                                "                  `,       '.       `.         |\n" +
                                "             __,.-'         `.        \\'       |\n" +
                                "            /_,-'\\          ,'        |        _.\n" +
                                "             |___.---.   ,-'        .-':,-\"`\\,' .\n" +
                                "                  L,.--\"'           '-' |  ,' `-.\\\n" +
                                "                                        `.' ");
                        else
                            if(un.getNombre().equals("Charizard"))
                                sb.append("                 .\"-,.__\n" +
                                    "                 `.     `.  ,\n" +
                                    "              .--'  .._,'\"-' `.\n" +
                                    "             .    .'         `'\n" +
                                    "             `.   /          ,'\n" +
                                    "               `  '--.   ,-\"'\n" +
                                    "                `\"`   |  \\\n" +
                                    "                   -. \\, |\n" +
                                    "                    `--Y.'      ___.\n" +
                                    "                         \\     L._, \\\n" +
                                    "               _.,        `.   <  <\\                _\n" +
                                    "             ,' '           `, `.   | \\            ( `\n" +
                                    "          ../, `.            `  |    .\\`.           \\ \\_\n" +
                                    "         ,' ,..  .           _.,'    ||\\l            )  '\".\n" +
                                    "        , ,'   \\           ,'.-.`-._,'  |           .  _._`.\n" +
                                    "      ,' /      \\ \\        `' ' `--/   | \\          / /   ..\\\n" +
                                    "    .'  /        \\ .         |\\__ - _ ,'` `        / /     `.`.\n" +
                                    "    |  '          ..         `-...-\"  |  `-'      / /        . `.\n" +
                                    "    | /           |L__           |    |          / /          `. `.\n" +
                                    "   , /            .   .          |    |         / /             ` `\n" +
                                    "  / /          ,. ,`._ `-_       |    |  _   ,-' /               ` \\\n" +
                                    " / .           \\\"`_/. `-_ \\_,.  ,'    +-' `-'  _,        ..,-.    \\`.\n" +
                                    ".  '         .-f    ,'   `    '.       \\__.---'     _   .'   '     \\ \\\n" +
                                    "' /          `.'    l     .' /          \\..      ,_|/   `.  ,'`     L`\n" +
                                    "|'      _.-\"\"` `.    \\ _,'  `            \\ `.___`.'\"`-.  , |   |    | \\\n" +
                                    "||    ,'      `. `.   '       _,...._        `  |    `/ '  |   '     .|\n" +
                                    "||  ,'          `. ;.,.---' ,'       `.   `.. `-'  .-' /_ .'    ;_   ||\n" +
                                    "|| '              V      / /           `   | `   ,'   ,' '.    !  `. ||\n" +
                                    "||/            _,-------7 '              . |  `-'    l         /    `||\n" +
                                    ". |          ,' .-   ,' ||               | .-.        `.      .'     ||\n" +
                                    " `'        ,'    `\".'    |               |    `.        '. -.'       `'\n" +
                                    "          /      ,'      |               |,'    \\-.._,.'/'\n" +
                                    "          .     /        .               .       \\    .''\n" +
                                    "        .`.    |         `.             /         :_,'.'\n" +
                                    "          \\ `...\\   _     ,'-.        .'         /_.-'\n" +
                                    "           `-.__ `,  `'   .  _.>----''.  _  __  /\n" +
                                    "                .'        /\"'          |  \"'   '_\n" +
                                    "               /_|.-'\\ ,\".             '.'`__'-( \\\n" +
                                    "                 / ,\"'\"\\,'               `/  `-.|\"");
                            else
                                if(un.getNombre().equals("Ivysaur"))
                                    sb.append("                               ,'\"`.,./.\n" +
                                        "                             ,'        Y',\"..\n" +
                                        "                           ,'           \\  | \\\n" +
                                        "                          /              . |  `\n" +
                                        "                         /               | |   \\\n" +
                                        "            __          .                | |    .\n" +
                                        "       _   \\  `. ---.   |                | j    |\n" +
                                        "      / `-._\\   `Y   \\  |                |.     |\n" +
                                        "     _`.    ``    \\   \\ |..              '      |,-'\"\"7,....\n" +
                                        "     l     '-.     . , `|  | , |`. , ,  /,     ,'    '/   ,'_,.-.\n" +
                                        "     `-..     `-.  : :     |/ `   ' \"\\,' | _  /          '-'    /___\n" +
                                        "      \\\"\"' __.,.-`.: :        /   /._    l'.,'\n" +
                                        "       `--,   _.-' `\".           /__ `'-.' '         .\n" +
                                        "       ,---..._,.--\"\"\"\"\"\"\"--.__..----,-.'   .  /    .'   ,.--\n" +
                                        "       |                          ,':| /    | /     ;.,-'--      ,.-\n" +
                                        "       |     .---.              .'  :|'     |/ ,.-='\"-.`\"`' _   -.'\n" +
                                        "       /    \\    /               `. :|--.  _L,\"---.._        \"----'\n" +
                                        "     ,' `.   \\ ,'           _,     `''   ``.-'       `-  -..___,'\n" +
                                        "    . ,.  .   `   __     .-'  _.-           `.     .__    \\\n" +
                                        "    |. |`        \"  ;   !   ,.  |             `.    `.`'---'\n" +
                                        "    ,| |C\\       ` /    | ,' |(]|            -. |-..--`\n" +
                                        "   /  \"'--'       '      /___|__]        `.  `- |`.\n" +
                                        "  .       ,'                   ,   /       .    `. \\\n" +
                                        "    \\                      .,-'  ,'         .     `-.\n" +
                                        "     x---..`.  -'  __..--'\"/\"\"\"\"\"  ,-.      |   |   |\n" +
                                        "    / \\--._'-.,.--'     _`-    _. ' /       |     -.|\n" +
                                        "   ,   .   `-..__ ...--'  _,.-' | `   ,.-.  ;   /  '|\n" +
                                        "  .  _,'         '\"-----\"\"      |    `   | /  ,'    ;\n" +
                                        "  |-'  .-.    `._               |     `._// ,'     /\n" +
                                        " _|    `-'   _,' \"`--.._________|        `,'    _ /.\n" +
                                        "//\\   ,-._.'\"/\\__,.   _,\"     /_\\__/`. /'.-.'.-/_,`-' mh\n" +
                                        "`-\"`\"' v'    `\"  `-`-\"              `-'`-`  `'");
                                else
                                    if(un.getNombre().equals("Venusaur"))
                                        sb.append("                           _._       _,._\n" +
                                            "                        _.'   `. ' .'   _`.\n" +
                                            "                ,\"\"\"/`\"\"-.-.,/. ` V'\\-,`.,--/\"\"\".\"-..\n" +
                                            "              ,'    `...,' . ,\\-----._|     `.   /   \\\n" +
                                            "             `.            .`  -'`\"\" .._   :> `-'   `.\n" +
                                            "            ,'  ,-.  _,.-'| `..___ ,'   |'-..__   .._ L\n" +
                                            "           .    \\_ -'   `-'     ..      `.-' `.`-.'_ .|\n" +
                                            "           |   ,',-,--..  ,--../  `.  .-.    , `-.  ``.\n" +
                                            "           `.,' ,  |   |  `.  /'/,,.\\/  |    \\|   |\n" +
                                            "                `  `---'    `j   .   \\  .     '   j\n" +
                                            "              ,__`\"        ,'|`'\\_/`.'\\'        |\\-'-, _,.\n" +
                                            "       .--...`-. `-`. /    '- ..      _,    /\\ ,' .--\"'  ,'\".\n" +
                                            "     _'-\"\"-    --  _`'-.../ __ '.'`-^,_`-\"\"\"\"---....__  ' _,-`\n" +
                                            "   _.----`  _..--.'        |  \"`-..-\" __|'\"'         .\"\"-. \"\"'--.._\n" +
                                            "  /        '    /     ,  _.+-.'  ||._'   \"\"\"\". .          `     .__\\\n" +
                                            " `---    /        /  / j'       _/|..`  -. `-`\\ \\   \\  \\   `.  \\ `-..\n" +
                                            ",\" _.-' /    /` ./  /`_|_,-\"   ','|       `. | -'`._,   L  \\ .  `.   |\n" +
                                            "`\"' /  /  / ,__...-----| _.,  ,'            `|----.._`-.|' |. .` ..  .\n" +
                                            "   /  '| /.,/   \\--.._ `-,' ,          .  '`.'  __,., '  ''``._ \\ \\`,'\n" +
                                            "  /_,'---  ,     \\`._,-` \\ //  / . \\    `._,  -`,  / / _   |   `-L -\n" +
                                            "   /       `.     ,  ..._ ' `_/ '| |\\ `._'       '-.'   `.,'     |\n" +
                                            "  '         /    /  ..   `.  `./ | ; `.'    ,\"\" ,.  `.    \\      |\n" +
                                            "   `.     ,'   ,'   | |\\  |       \"        |  ,'\\ |   \\    `    ,L\n" +
                                            "   /|`.  /    '     | `-| '                  /`-' |    L    `._/  \\\n" +
                                            "  / | .`|    |  .   `._.'                   `.__,'   .  |     |  (`\n" +
                                            " '-\"\"-'_|    `. `.__,._____     .    _,        ____ ,-  j     \".-'\"'\n" +
                                            "        \\      `-.  \\/.    `\"--.._    _,.---'\"\"\\/  \"_,.'     /-'\n" +
                                            "         )        `-._ '-.        `--\"      _.-'.-\"\"        `.\n" +
                                            "        ./            `,. `\".._________...\"\"_.-\"`.          _j\n" +
                                            "       /_\\.__,\"\".   ,.'  \"`-...________.---\"     .\".   ,.  / \\\n" +
                                            "              \\_/\"\"\"-'                           `-'--(_,`\"`-` mh");
    return sb.toString();
    } 
}