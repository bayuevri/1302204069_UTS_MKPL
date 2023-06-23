public void updateProfile(String firstName, String lastName, String gender, String studentIdentifierNumber,
                              String programStudy, String faculty, int enrollmentYear, String email,
                              String password, String userName) throws Exception {

    validateStudentIdentifierNumber(studentIdentifierNumber);
    validateEmailAndPassword(email, password);

    setSchoolIdentifier(programStudy, faculty, enrollmentYear);
    setSchoolAccount(email, password, userName);
    setGeneralInformation(firstName, lastName, gender, studentIdentifierNumber);

    printUpdateStatus();
}

private void validateStudentIdentifierNumber(String studentIdentifierNumber) throws Exception {
    if (studentIdentifierNumber.length() != 10 || !StringUtils.isNumeric(studentIdentifierNumber)) {
        throw new Exception("Input is not valid.");
    }
}

private void validateEmailAndPassword(String email, String password) throws Exception {
    boolean isValidEmail = isValidEmail(email);
    boolean isStrongPassword = isStrongPassword(password);

    if (!isValidEmail && !isStrongPassword) {
        throw new Exception("Please use a valid email and a strong password.");
    } else if (!isValidEmail) {
        throw new Exception("Please check your email.");
    } else if (!isStrongPassword) {
        throw new Exception("Please use a stronger password.");
    }
}

private void printUpdateStatus() {
    System.out.println("UPDATE COMPLETE!");
}
