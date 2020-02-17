# timetable-generator
This is a Java-based project to generate a timetable for a school based on specified constraints. Algorithm used involves greedy pre-processing (assigning a class to the least busy teacher) followed by a randomised generator to output the timetable that satisfies all constraints. Average runtime is 8 seconds for a school with 2036 students, 40 classes, 200 teachers and 45 classrooms. The project also allows for merging and splitting of classes as needed.
It reads its initial data of teachers, classes and subjects from an Excel file.

Documentation can be found [here](https://drive.google.com/open?id=1mO1_yHwe77nrEo0kxHWNdxn-zivEhhsG "PDF "). A detailed user manual, documentation and certification can be found [here](https://drive.google.com/drive/folders/12ObKKHioXFmHKC7UD4_BKSotKDg-XKTy "Drive Documentation")



## Constraints
1. Number of periods in a day = 8
2. Number of working days = 5
3. Maximum number of consecutive periods for a teacher (prevents tiring) = 3
4. Maximum number of periods for a teacher per day = 5
4. Maths cannot be taught in the last period of a day


## Steps for using the project
1. Download the Excel files `TestingFile.xlsm` and `OutFile.xlsm`(ensure that macros are enabled, and
  that the files are stored in the same folder)
2. Edit the `Subject` and `TeacherList` fields as needed.
3. Input pre-allocated classes if needed, in the Worksheets labelled "6A-12D"
4. Save all your changes in `TestingFile`.
5. Run `TimeTable.java`. The final timetable will be stored in `OutFile.xlsm`.
