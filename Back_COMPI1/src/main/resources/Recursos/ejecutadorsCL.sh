echo "INICIANDO COMPILADOR JFLEX"
java -jar /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/resources/Recursos/flex/jflex-full-1.9.1.jar -d /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Lexer/sCL /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Lexer/sCL/sCLLexer.flex
echo "INICIANDO COMPILADOR CUP"
java -jar /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/resources/Recursos/cup/cup-11a.jar -parser ParserScl -symbols ParserSym /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sCL/Parser.cup
mv ParserScl.java /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sCL/ParserScl.java
mv ParserSym.java /home/alesso/NetBeansProjects/Proyecto1-COMPI1/Back_COMPI1/src/main/java/com/mycompany/back_compi1/Parsers/sCL/ParserSym.java