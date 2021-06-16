package inlog;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subject {

    private String key;
    private String code;
    private String name;
    private int year;
    private String periode;
    private int ects;
    private String description;

    public Subject(){}

    public Subject(String key, String code, String name, int year, String periode, int ects, String description) {
        this.key = key;
        this.code = code;
        this.name = name;
        this.year = year;
        this.periode = periode;
        this.ects = ects;
        this.description = description;
    }

    @JsonIgnore
    public String getKey() {
        return key;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getPeriode() {
        return periode;
    }

    public int getEcts() {
        return ects;
    }

    public String getDescription() {
        return description;
    }

    private static ArrayList<Subject> allSubjects;
    static {
        allSubjects = new ArrayList<>();
        allSubjects.add(new Subject("FEP1", "TICT-SV1FEP1-20", "Front End Programming 1", 1, "D", 5,
                "Vak omtrent de basis van het programmeren van een Front End in HTML, CSS en JS"));
        allSubjects.add(new Subject("BEP1", "TCIF-V1BEP1-19", "Back End Programming 1", 1, "D", 5,
                "Vak omtrent de basis van het programmeren van een Back End met REST Interface in Java"));
        allSubjects.add(new Subject("IPASS", "TCIF-V1IPASS-19", "Individueel Project Assessment", 1, "D", 5,
                "Vak waarin je op basis van een individueel project de opgedaande kennis van de propedeuse moet aantonen"));
    }

    public static List<Subject> getAllSubjects() {
        return Collections.unmodifiableList(allSubjects);
    }

    public static Subject findSubject(String key){
        for(Subject s: allSubjects){
            if(s.getKey().equals(key)){
                return s;
            }
        }
        return null;
    }

    public void update(Subject nieuweSubjectData) {
        this.code = nieuweSubjectData.getCode();
        this.description = nieuweSubjectData.getDescription();
        this.ects = nieuweSubjectData.getEcts();
        this.periode = nieuweSubjectData.getPeriode();
        this.name = nieuweSubjectData.getName();
        this.year = nieuweSubjectData.getYear();

    }

    public void updateForm(String nieuweNaam, String nieuweDescription){
        this.name = nieuweNaam;
        this.description = nieuweDescription;
    }
}