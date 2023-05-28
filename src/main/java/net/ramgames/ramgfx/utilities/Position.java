package net.ramgames.ramgfx.utilities;

public class Position {

    private double x;
    private double y;
    private boolean userLocked;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
        this.userLocked = false;
    }

    public Position(double[] positionArray) {
        this.x = positionArray[0];
        this.y = positionArray[1];
        this.userLocked = false;
    }

    public double getX() {
        return this.x;
    }


    public double getY() {
        return this.y;
    }

    public double[] getPos() {
        return new double[]{(int) this.x, (int) this.y};
    }

    public double distanceFrom(Position position) {
        return Math.sqrt(Math.pow(this.x- position.x, 2)+Math.pow(this.y- position.y, 2));
    }

    public boolean setX(double x) {
        if (this.userLocked) {
            return false;
        }
        this.x = x;
        return true;
    }

    public boolean setY(double y) {
        if (this.userLocked) {
            return false;
        }
        this.y = y;
        return true;
    }

    public boolean addX(double x) {
        if (this.userLocked) {
            return false;
        }
        this.x = this.x + x;
        return true;
    }

    public boolean addY(double y) {
        if (this.userLocked) {
            return false;
        }
        this.y = this.y + y;
        return true;
    }

    public boolean getLocked() {
        return this.userLocked;
    }

    public boolean set(double x, double y) {
        if (this.userLocked) {
            return false;
        }
        setX(x);
        setY(y);
        return true;
    }

    public void setLock(boolean value) {
        this.userLocked = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position object) {
            return object.getX() == this.getX() && object.getY() == this.getY();
        }
        return false;
    }

    public RelativePosition asRelative(Position position) {
        return new RelativePosition(getX() - position.getX(), getY() - position.getY());
    }

    public RelativePosition relativeToOrigin() {
        return new RelativePosition(this.x, this.y);
    }

    public boolean advanceNorth(int value) {
        if (this.userLocked) {
            return false;
        }
        this.y -= value;
        return true;
    }

    public boolean advanceEast(int value) {
        if (this.userLocked) {
            return false;
        }
        this.x += value;
        return true;
    }

    public boolean advanceSouth(int value) {
        if (this.userLocked) {
            return false;
        }
        this.y += value;
        return true;
    }

    public boolean advanceWest(int value) {
        if (this.userLocked) {
            return false;
        }
        this.x -= value;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Pos[%s,%s]", this.x, this.y);
    }
}
