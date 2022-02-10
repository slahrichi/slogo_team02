# Cell Society API Lab Discussion
### Haris Adnan, Mike Keohane, Saad Lahrichi, Eric Xie
### TEAM 02


## Current Simulation API

### External

* Identified Classes/Methods
  - Simulation
* Goals
  - To contain and construct the simulation and pass the updated grid to the view.
* Contract
  - To be able to keep track of and return an updated grid based on the specified simulation
  - Assumes the user passes a set of parameters to initialize the Simulation (numberOfRows, numberOfColumns, setup,...)
* Services
  - Initializes and manages the cells' states in the grid, updates the cell states depending on the rules and updates the grid.

### Internal

* Identified Classes/Methods
  - Grid and Cell
* Goals
  - the Cell Class holds a method for each individiual cell and the View Class holds information of the state parameters and the condition of each cell inside it.

* Contract
  - To contain methods that would allow each cell to update according to the input parameters provided by the user
* Services
  - To provide implementation of the running state of the program.


## Wish Simulation API

### External

Potentially separate the public and protected methods in the Simulation class into its own external interface

* Goals
  - This would ensure the public Simulation methods can be reused by any new Simulation type, but also anything that resembles but it not quite a Simulation, as long as it has the expected parameters of the Interface (e.g. a static image)
* Contract
  - Has the ability to keep track of all of the states of a simulation, how they change, and return those states for external use.
  - Relies on initialization parameters read from a file specified by the user.
* Services
  - Provide an external interface for invoking data from the front-end/view model
  - Simulation class becomes more internal, making it more of a single-responsible class
  - Further emphasize the external/internal API design in the overall program


### Internal

* Goals
  - Same as current version, holding a method for each cell.

* Contract
  - Handle the multiple internal cell states based on the kind of simulation that's running

* Services
  - constitute basic building blocks of the Simulation regardless of the specfic Simulation type
