package Support;

import org.junit.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;

public class Check {

    public Check(){

    }

    public void containsInAnyOrderString(List<String> expectedResult, List<String> not_expectedResult, List<String> actualResult, Boolean sort){
        boolean isEqual = false;

        if (expectedResult == null && actualResult == null){
            Assert.assertTrue(isEqual);
        }

        if((expectedResult == null && actualResult != null)
                || expectedResult != null && actualResult == null){
            Assert.assertTrue(isEqual);
        }

        if(sort){
            Collections.sort(expectedResult);
            Collections.sort(actualResult);
        }

        //The list changes values - so its best to ensure that only comedies are returned as well as NOT films of another genre
        Assert.assertTrue((actualResult.containsAll(expectedResult) && !actualResult.containsAll(not_expectedResult)));

    }

    public void assertSequentialOrder(int[] actualResult, boolean descending){
        ArrayList<Boolean> result = new ArrayList<Boolean>();

        if(actualResult == null || actualResult.length < 1){
            result.add(false);
        }

        if(actualResult.length > 0 || actualResult != null){

            if(descending){
                for (int i = 0; i < actualResult.length-1; i++) {
                    if (actualResult[i] > actualResult[i+1] || actualResult[i] == actualResult[i+1] ) {
                        //do nothing
                    }else{
                        System.out.println(actualResult[i]);
                        System.out.println(actualResult[i+1]);
                        System.out.println(actualResult[i] > actualResult[i+1]);
                        System.out.println(actualResult[i] == actualResult[i+1]);
                        result.add(false);
                    }
                }

            }else if(!descending){
                for (int i = 0; i > actualResult.length-1; i++) {
                    if (actualResult[i] < actualResult[i+1] || actualResult[i] == actualResult[i+1] ) {
                        //do nothing
                    }else{
                        result.add(false);
                    }
                }
            }else{
                result.add(false);
            }
        }
        Assert.assertTrue(result.isEmpty()); //If it is populated then the check on sort failed.
    }

}
