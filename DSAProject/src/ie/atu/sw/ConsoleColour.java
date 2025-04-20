package ie.atu.sw;

/*
 * ANSI escape sequences are a standard for controlling cursor location, colour, 
 * font styling, and other options on DOS, Mac and Linux terminals. The ANSI escape 
 * codes are formatted as follows:
 * 
 *  	[<PREFIX>];[<COLOR>];[<TEXT DECORATION>]
 *  
 *  See https://en.wikipedia.org/wiki/ANSI_escape_code for a decent description.
 */

/**
 * Enum that defines various console colors and text styles using ANSI escape sequences.
 * Each constant in this enum represents a specific color or text style (bold, underline, background, etc.).
 * The associated color code can be used to format console output.
 */
public enum ConsoleColour { 
    /**
     * Resets the color settings to default.
     */
    RESET("Reset", "0"),

    //Regular Colours
    /**
     * Black color for text.
     */
    BLACK("Black [Regular]", "0;30"),
    
    /**
     * Red color for text.
     */
    RED("Red [Regular]", "0;31"),
    
    /**
     * Green color for text.
     */
    GREEN("Green [Regular]", "0;32"),
    
    /**
     * Yellow color for text.
     */
    YELLOW("Yellow [Regular]", "0;33"),
    
    /**
     * Blue color for text.
     */
    BLUE("Blue [Regular]", "0;34"),
    
    /**
     * Purple color for text.
     */
    PURPLE("Purple [Regular]", "0;35"),
    
    /**
     * Cyan color for text.
     */
    CYAN("Cyan [Regular]", "0;36"),
    
    /**
     * White color for text.
     */
    WHITE("White [Regular]", "0;37"),

    //Bold
    /**
     * Black color with bold text style.
     */
    BLACK_BOLD("Black [Bold]", "1;30"),
    
    /**
     * Red color with bold text style.
     */
    RED_BOLD("Red [Bold]", "1;31"),
    
    /**
     * Green color with bold text style.
     */
    GREEN_BOLD("Green [Bold]", "1;32"),
    
    /**
     * Yellow color with bold text style.
     */
    YELLOW_BOLD("Yellow [Bold]", "1;33"),
    
    /**
     * Blue color with bold text style.
     */
    BLUE_BOLD("Blue [Bold]", "1;34"),
    
    /**
     * Purple color with bold text style.
     */
    PURPLE_BOLD("Purple [Bold]", "1;35"),
    
    /**
     * Cyan color with bold text style.
     */
    CYAN_BOLD("Cyan [Bold]", "1;36"),
    
    /**
     * White color with bold text style.
     */
    WHITE_BOLD("White [Bold]", "1;37"),

    //Underline
    /**
     * Black color with underlined text style.
     */
    BLACK_UNDERLINED("Black [Underline]", "4;30"),
    
    /**
     * Red color with underlined text style.
     */
    RED_UNDERLINED("Red [Underline]", "4;31"),
    
    /**
     * Green color with underlined text style.
     */
    GREEN_UNDERLINED("Green [Underline]", "4;32"),
    
    /**
     * Yellow color with underlined text style.
     */
    YELLOW_UNDERLINED("Yellow [Underline]", "4;33"),
    
    /**
     * Blue color with underlined text style.
     */
    BLUE_UNDERLINED("Blue [Underline]", "4;34"),
    
    /**
     * Purple color with underlined text style.
     */
    PURPLE_UNDERLINED("Purple [Underline]", "4;35"),
    
    /**
     * Cyan color with underlined text style.
     */
    CYAN_UNDERLINED("Cyan [Underline]", "4;36"),
    
    /**
     * White color with underlined text style.
     */
    WHITE_UNDERLINED("White [Underline]", "4;37"),

    //Background
    /**
     * Black color as background.
     */
    BLACK_BACKGROUND("Black [Background]", "40"),
    
    /**
     * Red color as background.
     */
    RED_BACKGROUND("Red [Background]", "41"),
    
    /**
     * Green color as background.
     */
    GREEN_BACKGROUND("Green [Background]", "42"),
    
    /**
     * Yellow color as background.
     */
    YELLOW_BACKGROUND("Yellow [Background]", "43"),
    
    /**
     * Blue color as background.
     */
    BLUE_BACKGROUND("Blue [Background]", "44"),
    
    /**
     * Purple color as background.
     */
    PURPLE_BACKGROUND("Purple [Background]", "45"),
    
    /**
     * Cyan color as background.
     */
    CYAN_BACKGROUND("Cyan [Background]", "46"),
    
    /**
     * White color as background.
     */
    WHITE_BACKGROUND("White [Background]", "47"),

    //High intensity
    /**
     * Black color with high intensity.
     */
    BLACK_BRIGHT("Black [High Intensity]", "0;90"),
    
    /**
     * Red color with high intensity.
     */
    RED_BRIGHT("Red [High Intensity]", "0;91"),
    
    /**
     * Green color with high intensity.
     */
    GREEN_BRIGHT("Green [High Intensity]", "0;92"),
    
    /**
     * Yellow color with high intensity.
     */
    YELLOW_BRIGHT("Yellow [High Intensity]", "0;93"),
    
    /**
     * Blue color with high intensity.
     */
    BLUE_BRIGHT("Blue [High Intensity]", "0;94"),
    
    /**
     * Purple color with high intensity.
     */
    PURPLE_BRIGHT("Purple [High Intensity]", "0;95"),
    
    /**
     * Cyan color with high intensity.
     */
    CYAN_BRIGHT("Cyan [High Intensity]", "0;96"),
    
    /**
     * White color with high intensity.
     */
    WHITE_BRIGHT("White [High Intensity]", "0;97"),

    //Bold high intensity
    /**
     * Black color with bold high intensity.
     */
    BLACK_BOLD_BRIGHT("Black [Bold High Intensity]", "1;90"),
    
    /**
     * Red color with bold high intensity.
     */
    RED_BOLD_BRIGHT("Red [Bold High Intensity]", "1;91"),
    
    /**
     * Green color with bold high intensity.
     */
    GREEN_BOLD_BRIGHT("Green [Bold High Intensity]", "1;92"),
    
    /**
     * Yellow color with bold high intensity.
     */
    YELLOW_BOLD_BRIGHT("Yellow [Bold High Intensity]", "1;93"),
    
    /**
     * Blue color with bold high intensity.
     */
    BLUE_BOLD_BRIGHT("Blue [Bold High Intensity]", "1;94"),
    
    /**
     * Purple color with bold high intensity.
     */
    PURPLE_BOLD_BRIGHT("Purple [Bold High Intensity]", "1;95"),
    
    /**
     * Cyan color with bold high intensity.
     */
    CYAN_BOLD_BRIGHT("Cyan [Bold High Intensity]", "1;96"),
    
    /**
     * White color with bold high intensity.
     */
    WHITE_BOLD_BRIGHT("White [Bold High Intensity]", "1;97"),

    //High Intensity backgrounds
    /**
     * Black background with high intensity.
     */
    BLACK_BACKGROUND_BRIGHT("Black [High Intensity BG]", "0;100"),
    
    /**
     * Red background with high intensity.
     */
    RED_BACKGROUND_BRIGHT("Red [High Intensity BG]", "0;101"),
    
    /**
     * Green background with high intensity.
     */
    GREEN_BACKGROUND_BRIGHT("Green [High Intensity BG]", "0;102"),
    
    /**
     * Yellow background with high intensity.
     */
    YELLOW_BACKGROUND_BRIGHT("Yellow [High Intensity BG]", "0;103"),
    
    /**
     * Blue background with high intensity.
     */
    BLUE_BACKGROUND_BRIGHT("Blue [High Intensity BG]", "0;104"),
    
    /**
     * Purple background with high intensity.
     */
    PURPLE_BACKGROUND_BRIGHT("Purple [High Intensity BG]", "0;105"),
    
    /**
     * Cyan background with high intensity.
     */
    CYAN_BACKGROUND_BRIGHT("Cyan [High Intensity BG]", "0;106"),
    
    /**
     * White background with high intensity.
     */
    WHITE_BACKGROUND_BRIGHT("White [High Intensity BG]", "0;107");
    
    //Control Sequence Introducer. ASCII Octal = \033, ASCII Hex = \0x1B, Shell = \e
    private static final String CTRL_SEQ_INTRO = "\033[";  
    private static final String CTRL_SEQ_END = "m"; //Terminates control  
    private final String description;
    private final String colour;
    
    /**
     * Constructor for ConsoleColour.
     * @param description A description of the color or text style.
     * @param colour The corresponding ANSI code for the color or text style.
     */
    ConsoleColour(String description, String colour) {
        this.description = description;
        this.colour = colour;
    }
    
    /**
     * Gets the description of the color or text style.
     * @return The description of the color.
     */
    public String description() { 
        return this.description; 
    }

    /**
     * Gets the ANSI color code for the color or text style.
     * @return The ANSI code as a string.
     */
    public String colour() { 
        return toString();
    }
    
    @Override
    public String toString() {
        return CTRL_SEQ_INTRO + this.colour + CTRL_SEQ_END; 
    }
}
