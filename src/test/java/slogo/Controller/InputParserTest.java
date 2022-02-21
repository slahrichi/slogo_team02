package slogo.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {
  private InputParser myParser;

  @BeforeEach
  void setUp() {
    myParser = new InputParser();
    // order added matters
    myParser.addPatterns("English");
    myParser.addPatterns("Syntax");
  }

  @Test
  void getCommands() {
    //needs to call parseText first
    assertEquals(myParser.validCommands, null);
  }

  @Test
  void addPatterns()
      throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    assertEquals(myParser.mySymbols, "[ClearScreen=clearscreen|cs, IsShowing=showing\\?|showingp, Left=left|lt, Or=or, SetPosition=setxy|goto, Product=product|\\*, Sine=sine|sin, Repeat=repeat, Difference=difference|-, MakeVariable=make|set, GreaterEqual=greaterequal\\?|\\>\\=, LessThan=less\\?|\\<, IsPenDown=pendown\\?|pendownp, Random=random|rand, GreaterThan=greater\\?|\\>, Equal=equal\\?|\\=\\=, SetHeading=setheading|seth, Pi=pi, PlayButton=Play, YCoordinate=ycor, NotEqual=notequal\\?|\\!\\=, LessEqual=lessequal\\?|\\<\\=, For=for, Sum=sum|\\+, ArcTangent=arctangent|atan, Not=not, And=and, ClearHistory=Clear History, DoTimes=dotimes, XCoordinate=xcor, SetTowards=towards, If=if, Minus=minus|~, HideTurtle=hideturtle|ht, Cosine=cosine|cos, PenDown=pendown|pd, Heading=heading, IfElse=ifelse, Right=right|rt, Remainder=remainder|%, Backward=back|bk, SquareRoot=squareroot|sqrt, NaturalLog=log, Home=home, PenUp=penup|pu, Tangent=tangent|tan, MakeUserInstruction=to, RandomRange=randomrange|randr, SaveFile=Save File, LoadFile=Load File, Forward=forward|fd, ShowTurtle=showturtle|st, Quotient=quotient|/, Power=power|pow]\n");
  }

  @Test
  void addSyntaxPatterns() {
    assertEquals(myParser.mySyntaxSymbols, "    [Comment=^#.*, UserCommand=[a-zA-Z_]+(\\?)?|[*+-/%~], Variable=:[a-zA-Z]+, Constant=-?[0-9]+\\.?[0-9]*, ListStart=\\[, ListEnd=\\]]\n" );
  }

  @Test
  void setLanguage() {
    myParser.setLanguage("French");
    assertEquals(myParser.mySymbols, "[ClearScreen=effacerecran|ee, IsShowing=visible\\?|visiblep, Left=gauche|gc, Or=ou, SetPosition=positionexy|aller, Product=produit|\\*, Sine=sine|sin, Repeat=repete, Difference=difference|-, MakeVariable=faire|ensemble, GreaterEqual=superieuregal\\?|\\>\\=, LessThan=inferieur\\?|\\<, IsPenDown=styloactif\\?|styloactifp, Random=aleatoire|alea, GreaterThan=superieur\\?|\\>, Equal=egal\\?|\\=\\=, SetHeading=definirentete|defett, Pi=pi, YCoordinate=cory, NotEqual=different\\?|\\!\\=, LessEqual=inferieuregal\\?|\\<\\=, For=pour, Sum=somme|\\+, ArcTangent=arctangent|atan, Not=non, And=et, DoTimes=dotimes, XCoordinate=corx, SetTowards=vers, If=si, Minus=moins|~, HideTurtle=cachertortue|ct, Cosine=cosine|cos, PenDown=styloactif|sac, Heading=entete, IfElse=sinon, Right=droite|dr, Remainder=reste|%, Backward=derriere|der, SquareRoot=squareroot|sqrt, NaturalLog=log, Home=maison, PenUp=styloinactif|sic, Tangent=tangent|tan, MakeUserInstruction=fait, RandomRange=randomrange|randr, Forward=devant|dev, ShowTurtle=montrertortue|mt, Quotient=quotient|/, Power=power|pow]\n");
  }

  @Test
  void getSymbol() {
    myParser.setLanguage("English");
    assertEquals(myParser.getSymbol("Duvall"), "NO MATCH");
    assertEquals(myParser.getSymbol("fd"), "forward|fd");
  }

  @Test
  void getSyntaxSymbol() {
    myParser.setLanguage("English");
    assertEquals(myParser.getSymbol("Duvall"), "NO MATCH");

  }

  @Test
  void match() {
    assertEquals(myParser.match("", Pattern.compile("-?[0-9]+\\.?[0-9]*\n")), false);
  }

  @Test
  void reset() {
    assertEquals(myParser.mySymbols, null);
  }

  @Test
  void readFile() {
  }

  @Test
  void main() {
  }
}