from mocks.smartparking.Sensor import Sensor
from mocks.smartparking.Server import Server
from mocks.smartparking.MobileApp import MobileApp

class WrapperFactory:

    def createSensor(self):
        return Sensor()

    def createServer(self):
        return Server()

    def createMobileApp(self):
        return MobileApp()


