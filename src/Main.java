import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[]args){
        ArrayList<Students> students = new ArrayList<>();

        Students shamil = new Students("Шамиль", 20, "11-804", 68);
        Students damir = new Students("Дамир", 25, "11-804", 17);
        Students remir = new Students("Ремир", 21,"11-804", 67);
        Students kemir = new Students("Кемир", 21,"11-804", 71);
        Students rinat = new Students("Ринат", 20,"11-704", 80);
        Students tanya = new Students("Таня", 19, "11-704", 16);
        Students masha = new Students("Маша", 20, "11-904", 99);
        Students arslan = new Students("Aрслан",19,"11-904", 93);

        students.add(shamil);
        students.add(remir);
        students.add(rinat);
        students.add(tanya);
        students.add(arslan);
        students.add(masha);
        students.add(kemir);
        students.add(damir);

        for (int i = 0; i < students.size() - 1; i++){
            for (int j = 0; j < students.size() - 1; j++){
                if (students.get(j).getAverageScore() > students.get(j + 1).getAverageScore()){
                    Students st = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, st);
                }
            }

        }

        System.out.println("3 студента с лучшим средним баллом: ");
        for (int i = 1; i < 4; i++){
            System.out.println(students.get(students.size() - i).getName());
        }

        int max = 1;
        int min = 1;

        int stMax = students.size() - 1;
        int stMin = 0;

        int dif1 = 1;
        int dif2 = 1;

        while (students.get(stMax).getAverageScore() == students.get(stMax - dif1).getAverageScore()){
            dif1++;
            max++;
        }
        System.out.println("количество студентов с максимальным баллом: " + max);

        while (students.get(stMin).getAverageScore() == students.get(stMin + dif2).getAverageScore()){
            dif2++;
            min++;
        }
        System.out.println("количество студентов с минимальным баллом: " + min);

        Map<String, Students> bestScore = new HashMap<>();
        for (int i = 0; i < students.size(); i++){
            Students curSt = students.get(i);
            if (bestScore.containsKey(curSt.getGroup())){
                if (bestScore.get(curSt.getGroup()).getAverageScore() < curSt.getAverageScore()){
                    bestScore.put(curSt.getGroup(), curSt);
                }
            }
            else {
                bestScore.put(curSt.getGroup(), curSt);
            }
        }
        Set groupsSet = bestScore.keySet();

        Object[] groups;
        groups = groupsSet.toArray();

        for (int i = 0; i < bestScore.size(); i++){
            String studentName = bestScore.get(groups[i]).getName();
            System.out.println("Лучший студент из группы " + groups[i] + " - " + studentName);
        }
    }
}

