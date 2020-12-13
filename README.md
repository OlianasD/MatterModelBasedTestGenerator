Executable test case generation tool
=======
This repository contains the tool implementing the approach described in a submission to Software Quality Journal, along with an implementation of the two systems under test and related artifacts.
It is organized as follows:

* **DiaMH/** : contains all the material related to the Diabetes Mobile Health System used as case study for our approach, including model and generated mutants. Instructions for deployment are contained in DiaMH/README.md
* **SmartParking/** : contains all the material related to the SmartParking system used as case study for our approach, including model and generated mutants. Instructions for deployment are contained in SmartParking/README.md
* **MutantRunner/** : contains the tool used to automatically deploy mutants and execute the test suite against them. It is divided in server side (that starts and stop the Node-RED server with the required mutant) and client side (that commands the server side and executes the test suite)
* **MatterModelBasedTestGenerator/** : contains the actual test generation tool


Information about dependencies and deployment instructions can be found in README files inside such directories.
