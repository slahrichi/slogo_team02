open module slogo_app {
    // list all imported class packages since they are dependencies
    requires javafx.controls;
    requires javafx.base;
    requires javafx.media;
    requires javafx.web;
    requires javafx.graphics;
    requires java.desktop;

    // allow other classes to access listed packages in your project
    exports slogo;
    exports slogo.Model;
    exports slogo.Model.Commands;
  exports slogo.Model.Commands.ControlStructures;
  exports slogo.Model.Commands.TurtleCommands;
  exports slogo.Control;

}