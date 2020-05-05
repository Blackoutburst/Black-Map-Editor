package Math;

public class Vector2f
{
    public float x;
    public float y;
    
    public Vector2f(final float x, final float y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector2f set(final float x, final float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    public Vector2f normalize() {
        final float mag = (float)Math.sqrt(this.x * this.x + this.y * this.y);
        this.x /= mag;
        this.y /= mag;
        return this;
    }
    
    public float length() {
        final float mag = (float)Math.sqrt(this.x * this.x + this.y * this.y);
        return mag;
    }
}
