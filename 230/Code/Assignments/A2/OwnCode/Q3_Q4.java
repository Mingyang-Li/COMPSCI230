class DynamicRectangleShape extends RectangleShape {
    private Color color;
    private Boolean bounced;
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x, y, deltaX, deltaY, width, height);
        this.color = Color.red; 
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color) {
        super(x, y, deltaX, deltaY, width, height);
        this.color = color; 
    }
    @Override public void move(int width, int height){
        /*
        if (the shape bounced){
            bounced = true;
        }
        */
        //super.move(super.width, super.height);
    }
    @Override public void paint(Painter painter){
        /*
        if (color is not provide in constructor){
            paint it red 
            super.paint(Color.red); 
        } else {
            paint it with the color specified 
        }
         */
    }
}
