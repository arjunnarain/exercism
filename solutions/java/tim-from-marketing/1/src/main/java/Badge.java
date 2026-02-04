class Badge {
    public String print(Integer id, String name, String department) {
        String safeName = (name == null) ? "" : name;
        String safeDepartment = (department == null) ? "OWNER" : department;
        String safeId = (id == null) ? "" : String.valueOf(id);

        if (id == null) {
            return String.format("%s - %s", safeName, safeDepartment.toUpperCase());
        }
        
        return String.format("[%s] - %s - %s", safeId, name, safeDepartment.toUpperCase());
    }
}
