import contract.AuthStrategy;


    public class ATM {
        private AuthStrategy authStrategy;

        public void setAuthStrategy(AuthStrategy authStrategy) {
            this.authStrategy = authStrategy;
        }

        public boolean authenticateUser(String data) {
            return authStrategy.authenticate(data);
        }
    }
