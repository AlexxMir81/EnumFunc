public  enum Transmission {
        reverse(-1,-20),
        one(0,20),
        two(21,40),
        three(41,60),
        four(61,80),
        five(81,100);


        public Transmission Movie(int speed, Speed currentSpeed) {
            Transmission currentTransmition = Transmission.one;
            if (speed>currentSpeed.currSpeed){
                while (currentSpeed.currSpeed<speed) {
                    for (int i = 0; i < Transmission.values().length; i++) {
                        if (currentSpeed.currSpeed>= Transmission.values()[i].minSpeed && currentSpeed.currSpeed <= Transmission.values()[i].maxSpeed &&speed!=0) {
                            if (Transmission.values()[i].maxSpeed < currentSpeed.currSpeed) {
                                System.out.println("Текущая передача " + (i+1));
                            } else {
                                System.out.println("Текущая передача " + (i));
                            }
                            currentSpeed.currSpeed += this.stepSpeed;
                            System.out.println("Текущая скорость " + currentSpeed.currSpeed);
                            currentTransmition = Transmission.values()[i];
                        }
                        if (currentSpeed.currSpeed<= Transmission.values()[i].minSpeed && currentSpeed.currSpeed >= Transmission.values()[i].maxSpeed){
                            System.out.println("Задняя передача");

                            currentSpeed.currSpeed += this.stepSpeed;
                            System.out.println("Текущая скорость " + currentSpeed.currSpeed);

                            currentTransmition = Transmission.values()[i];
                        }
                    }

                }
            }else {
                while (currentSpeed.currSpeed!=speed) {
                    for (int i = Transmission.values().length-1; i >= 0 ; i--) {
                        if (currentSpeed.currSpeed>= Transmission.values()[i].minSpeed && currentSpeed.currSpeed <= Transmission.values()[i].maxSpeed) {
                            if (Transmission.values()[i].maxSpeed >= currentSpeed.currSpeed) {
                                System.out.println("Текущая передача " + (i));
                            } else {
                                System.out.println("Текущая передача " + (i-1));
                            }
                            System.out.println("Текущая скорость " + currentSpeed.currSpeed);
                            currentSpeed.currSpeed -= this.stepSpeed;

                            currentTransmition = Transmission.values()[i];
                        }
                        if (currentSpeed.currSpeed<= Transmission.values()[i].minSpeed && currentSpeed.currSpeed >= Transmission.values()[i].maxSpeed) {
                            System.out.println("Задняя передача");
                            System.out.println("Текущая скорость " + currentSpeed.currSpeed);
                            currentSpeed.currSpeed -= this.stepSpeed;

                            currentTransmition = Transmission.values()[i];
                        }

                    }
                }
            }
            return  currentTransmition;
        }


        private final int minSpeed, maxSpeed;
        private int stepSpeed = 10;
        Transmission(int minSpeed, int maxSpeed){
            this.minSpeed = minSpeed;
            this.maxSpeed = maxSpeed;
        }

        public void setStepSpeed(int stepSpeed) {
            this.stepSpeed = stepSpeed;
        }

        public int getStepSpeed() {
            return stepSpeed;
        }

        @Override
        public String toString() {
            return "Transmission"+this.name();
        }
}
