package viewmodels;

public class InitialConfigActivityViewModel {

    public boolean isValidName(String name) {
        return !name.trim().isEmpty();
    }

    public int checkHealth(String difficulty) {
        if (difficulty.equals("Easy")) {
            return 100;
        } else if (difficulty.equals("Medium")) {
            return 75;
        } else {
            return 50;
        }
    }

    public boolean checkValidXCoordinates(int x) {
        if (x < 0 || x > 1000) {
            return false;
        }
        return true;
    }

    public boolean checkValidYCoordinates(int y) {
        if (y < 0 || y > 500) {
            return false;
        }
        return true;
    }
}
