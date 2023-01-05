public class Search {

    private final FamilyTree familyTree;

    public Search(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    // поиск родителей
    public void findParents(String name) {
        if (isMember(name)) {
            if (familyTree.getParents(name).isEmpty()) {
                System.out.println(name + " не имеет родителей");
            } else {
                System.out.println("Родители " + name + ":");
                familyTree.getParents(name).stream().forEach(parent -> System.out.println(parent.getName()));
            }
        }
    }

    // поиск детей
    public void findChildren(String name) {
        try {
            if (familyTree.getMember(name).getChildren().isEmpty()) {
                System.out.println(name + " не имеет детей");
            } else {
                System.out.println("Дети " + name + ": ");
                familyTree.getMember(name).getChildren().stream().forEach(child -> System.out.println(child.getName()));
            }
        } catch (Exception e) {
            System.out.println(name + " не является членом генеалогического древа");
        }
    }

    // поиск брата или сестры
    public void areSiblings(String firstName, String secondName) {
        if (isMember(firstName) && isMember(secondName)) {
            if (familyTree.getParents(firstName).equals(familyTree.getParents(secondName))) {
                System.out.println(firstName + " и " + secondName + " братья или сестры");
            } else {
                System.out.println(firstName + " и " + secondName + " не являются братьями или сестрами");
            }
        }
    }
    // показать всех членов генеалогического древа 
    public void showAllMembers() {
        familyTree.getFamilyTree().stream().forEach(member -> System.out.println(member.getName()));
    }
    // проверка на правильность ввода
    private boolean isMember(String name) {
        if (!familyTree.getFamilyTree().contains(familyTree.getMember(name))) {
            System.out.println(name + " не член генеалогического древа");
            return false;
        }
        return true;
    }
}
