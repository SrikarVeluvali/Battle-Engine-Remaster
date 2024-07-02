public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    public static void main(String[] args) {
        System.out.println(ConsoleColors.BLACK + "Black text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED + "Red text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN + "Green text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "Yellow text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Blue text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE + "Purple text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN + "Cyan text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE + "White text" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLACK_BOLD + "Bold black text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD + "Bold red text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD + "Bold green text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD + "Bold yellow text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD + "Bold blue text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD + "Bold purple text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "Bold cyan text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD + "Bold white text" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLACK_BACKGROUND + "Black background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BACKGROUND + "Red background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BACKGROUND + "Green background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BACKGROUND + "Yellow background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BACKGROUND + "Blue background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BACKGROUND + "Purple background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BACKGROUND + "Cyan background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BACKGROUND + "White background" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLACK_BRIGHT + "High intensity black text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BRIGHT + "High intensity red text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BRIGHT + "High intensity green text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "High intensity yellow text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BRIGHT + "High intensity blue text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BRIGHT + "High intensity purple text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BRIGHT + "High intensity cyan text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BRIGHT + "High intensity white text" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT + "Bold high intensity black text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Bold high intensity red text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Bold high intensity green text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "Bold high intensity yellow text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Bold high intensity blue text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "Bold high intensity purple text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "Bold high intensity cyan text" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "Bold high intensity white text" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT + "High intensity black background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + "High intensity red background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + "High intensity green background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + "High intensity yellow background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + "High intensity blue background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + "High intensity purple background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + "High intensity cyan background" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + "High intensity white background" + ConsoleColors.RESET);
        
        System.out.println(ConsoleColors.RESET + "Reset text color");
    }   
}
