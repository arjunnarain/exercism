class Badge {
    public String print(Integer id, String name, String department) {
        String safeName = (name == null) ? "" : name;
        String safeDepartment = (department == null) ? "OWNER" : department;
        String safeId = (id == null) ? "" : String.valueOf(id);

        if (id == null) {
            return safeName + " - " + safeDepartment.toUpperCase();
        }
        
        return "[" + safeId + "] - " + safeName + " - " + safeDepartment.toUpperCase();
    }
}
