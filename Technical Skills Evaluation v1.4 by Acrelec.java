/*Technical Skills Evaluation v1.4 by Acrelec
Test Date: 17/02/2022
Challenge Sent by: Marina Barutti
Name of candidate: Elias Barreto Ferreira Filho	

1 - The difference between a structure based on a stack and a structure built in a queue, is due to the fact that the stack follows the LIFO paradigm, in which the last element to enter will always
    be the first to leave, it consists of 2 manipulations, the push(insert) and pop(remove). In the queue, the applied paradigm is the FIFO, in which the first in is the first out, that is, the only
    removal modification is applied to the first element inserted in the structure.

2 - When the user needs a structure that supports and provides a greater change of position, insertion and removal or if he has several different data types within that collection, the most indicated
    would be a list, but if the user needs it of a set with a large number of elements contained or that will require several manipulations in the value of the index in question, the most indicated would
    be an array.
    
3 - In a hash table structure, a data collision occurs when records with different keys try to allocate the same position within this hash table, thus causing a mapping problem and conflict in the structure.
*/

// MainClass for Testing code.
public class main {
    public static void main(String[] args) {

        System.out.println(questionFourSolution(15464848));
        System.out.println(questionFiveSolution("{[()()]}"));
        System.out.println(questionSixSolution(9));
        System.out.println(questionSevenSolution(5, 7));

        QuestionEightSolution rotate = new QuestionEightSolution();
        int numbers[] = { 3, 8, 9, 7, 6 };
        int z[] = rotate.leftRotateNumbers(numbers, Math.abs(-1), numbers.length);
    }

    // Solution Number 4
    public static boolean questionFourSolution(int n) {

        boolean z = false;

        int arrayInt[] = Integer.toString(n).chars().map(c -> Character.getNumericValue((char)c)).toArray();
        int lastPositionNumber = arrayInt[arrayInt.length-1];

        switch (Math.abs(lastPositionNumber)) {
            case (0):
            case (2):
            case (4):
            case (6):
            case (8):
                z = true;
            break;
            default:
                z = false;
            break;
        }
        return z;
    }

    // Solution Number 5
    public static boolean questionFiveSolution(String S) {

        boolean z = false;
        Deque<Character> stackCharacter = new LinkedList<>();

        for (int counter = 0; counter < S.length(); counter++) {
            char item = S.charAt(counter);

            switch (item) {
                case ')':
                    if (stackCharacter.isEmpty() || stackCharacter.pop() != '(')
                        return z = false;
                    break;
                case ']':
                    if (stackCharacter.isEmpty() || stackCharacter.pop() != '[')
                        return z = false;
                    break;
                case '}':
                    if (stackCharacter.isEmpty() || stackCharacter.pop() != '{')
                        return z = false;
                    break;
                default:
                    stackCharacter.push(item);
                    break;
            }
        }
        return z = stackCharacter.isEmpty() ? true : false;
    }

    // Solution Number 6
    public static int questionSixSolution(int n)
    {
        int y = 0;
        int zeros = 0;

        while ((n > 0) && ((n & 1) == 0)) {
            n >>= 1;
        }
        n >>= 1;

        while (n > 0) {
            if ((n & 1) == 0) {
                zeros++;
            } else {
                y = Math.max(y, zeros);
                zeros = 0;
            }
            n >>= 1;
        }

        return y;
    }

    // Solution Number 7
    public static int questionSevenSolution(int x, int y) {
        int shiftCount = 0;
        int z = 0;

        while (x != y && x > 0) {
            x = x >> 1;
            y = y >> 1;

            shiftCount++;
        }

        return z = (x << shiftCount);
    }
}

// Solution Number 8
class QuestionEightSolution{

    public int[] leftRotateNumbers(int arr[], int n, int nRotate)
    {
        n = n % nRotate;
        int index, positionJ, positionK, arrTemp;
        int gcd = getsGcdValue(n, nRotate);

        for (index = 0; index < gcd; index++) {
            arrTemp = arr[index];
            positionJ = index;
            while (true) {
                positionK = positionJ + n;
                if (positionK >= nRotate)
                    positionK = positionK - nRotate;
                if (positionK == index)
                    break;
                arr[positionJ] = arr[positionK];
                positionJ = positionK;
            }
            arr[positionJ] = arrTemp;
        }

        return writtenArray(arr, arr.length);
    }

    public int[] writtenArray(int arr[], int size)
    {
        for (int i = 0; i < size; i++) {
             System.out.print(arr[i] + " ");
        }

        return arr;
    }

    public int getsGcdValue(int x, int y)
    {
        if (y == 0)
            return x;
        else
            return getsGcdValue(y, x % y);
    }
}