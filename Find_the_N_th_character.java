class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        StringBuilder sbr = new StringBuilder(s);
        while (r--> 0){
            s = sbr.toString();
            sbr.replace(0, sbr.length(), "");
            int i = 0;
            while (sbr.length() <= n){
                sbr.append(getStr(s.charAt(i++)));
            }
        }
        return sbr.charAt(n);
    }
    
    static String getStr(char c){
        return c == '0' ? "01" : "10";
    }
}
