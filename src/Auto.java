public class Auto {
        private Speed currentSpeed;
        private Transmission currentTransmission;
        public void setCurrentTransmission(Transmission currentTransmission){
            this.currentTransmission = currentTransmission;
        }

        public Auto() {

            this.currentSpeed = new Speed(0);
            this.currentTransmission = Transmission.one;
        }

        void forward(int speed){
            currentTransmission = currentTransmission.Movie(speed, this.currentSpeed);
        }
        void stop(){
            currentTransmission = currentTransmission.Movie(0, this.currentSpeed);
        }
        void reverse(){
            currentTransmission = currentTransmission.Movie(-20, this.currentSpeed);
        }

        @Override
        public String toString() {
            return "Auto{" +
                    "currentSpeed=" + currentSpeed.currSpeed +
                    ", currentTransmission=" + currentTransmission +
                    '}';
        }

}
