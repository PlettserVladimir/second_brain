class Parent {
    Parent(String name) { /* ... */ }
}

class Child extends Parent {
    private final String childName;
    Child(String name) {
        if (name == null) name = "default";  // код до super()
        super(name);
        this.childName = name;
    }
}