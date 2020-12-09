DiaMH
==============

This directory contains the IoT system prototype used as case study for the proposed approach. It is organized as follows:

* **SmartParking Node-RED/** : contains the Node-RED flows that implement the servver side of SmartParking, namely the SmartParking Server and the Sensor manager. To deploy, just import the JSON files in Node-RED.
* **SmartParking Mobile/** : contains the Android app for the SmartParking client. Before compiling, you should set the address of the Node-RED host in the "host" field of the strings.xml resource file.
						  (SmartParking Mobile/SmartParking/app/src/main/res/values/strings.xml)

* **Mutants/** : mutants generated for SmartParking

* **Model/** : contains the Class Diagram and the State Machine Diagram for SmartParking, along with an SCXML representation of the state machine diagram to be used by the tool.

Dependencies
------

* **Node-RED 0.18.4**
* **Android Studio 2.3.2 **