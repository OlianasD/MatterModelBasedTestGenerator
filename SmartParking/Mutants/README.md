Mutants for SmartParking
==============

This directory contains mutants generated for SmartParking, organized as follows:

* **sensor/, server/, sql/** : mutants respectively generated for the Sensor manager component, for the Server component and for SQL queries. Each directory inside the first two corresponds to the Node-RED 								function node in which the mutant is located. For SQL, the "original" directory contains the original code of function nodes, the js_mutants directory contains the code of 									nodes with the mutated query

* **executableNodeREDflows/** : contains ready-to-run Node-RED flows with mutated nodes

