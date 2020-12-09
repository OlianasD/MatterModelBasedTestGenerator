class Server:

    def __init__(self):
        self.maxCar = 11
        self.maxMoto = 8
        self.maxHandicap = 5
        self.nCar = 0
        self.nMoto = 0
        self.nHandicap = 0

    def newVehicle(self, vtype):
        if(vtype == 'car'):
            self.nCar += 1
        elif(vtype == 'moto'):
            self.nMoto += 1
        elif(vtype == 'handicap'):
            self.nHandicap += 1
        else:
            raise Exception('Invalid vehicle type '+vtype)

    def vehicleLeaves(self, vtype):
        if(vtype == 'car'):
            self.nCar -= 1
        elif(vtype == 'moto'):
            self.nMoto -= 1
        elif(vtype == 'handicap'):
            self.nHandicap -= 1
        else:
            raise Exception('Invalid vehicle type '+vtype)

    def setAllFree(self):
        return 0