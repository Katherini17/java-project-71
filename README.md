# File Comparison CLI
### Hexlet tests and linter status:
[![Actions Status](https://github.com/Katherini17/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Katherini17/java-project-71/actions)
### Github actions status:
[![Java CI with Gradle](https://github.com/Katherini17/java-project-71/actions/workflows/gradle.yml/badge.svg)](https://github.com/Katherini17/java-project-71/actions/workflows/gradle.yml)
### Quality Gate Status:
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Katherini17_java-project-71&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=Katherini17_java-project-71)
### Coverage:
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Katherini17_java-project-71&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Katherini17_java-project-71)
### Code smell:
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Katherini17_java-project-71&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=Katherini17_java-project-71)
### Bugs:
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Katherini17_java-project-71&metric=bugs)](https://sonarcloud.io/summary/new_code?id=Katherini17_java-project-71)
### Duplicated lines:
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Katherini17_java-project-71&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=Katherini17_java-project-71)

### Description
File Comparison CLI is a command-line utility that compares 
two configuration files (JSON or YAML) and outputs the differences 
in a human-readable format.

### Output Styles:
* Stylish (default): Presents the differences in a nested, human-readable format.
* Plain: Provides a simplified, text-based output.
* JSON: Outputs the differences as a JSON object.

### Prerequisites:
* JDK 17 or higher
* Gradle

### Building
1. Clone the repository:
```bash
git clone https://github.com/Katherini17/java-project-71.git
cd java-project-71/app
```
2. Build the application:
```bash
make -С app build
```

3. Install the application:
```bash
make install
```

4. Run the application:
```bash
make run-dist ARGS="[options] <filepath1> <filepath2> [options]"
```
Where:
*   `<filepath1>` is the path to the first configuration file (JSON or YAML).
*   `<filepath2>` is the path to the second configuration file (JSON or YAML).
*   `[options]` are the command-line options.

### Command-Line Options:

`-f, --format <format>`: Specifies the output format. Valid values are `stylish` (default), `plain`, and `json`.

## Examples:

#### file1.json
```json
{
  "setting1": "Some value",
  "setting2": 200,
  "setting3": true,
  "key1": "value1",
  "numbers1": [1, 2, 3, 4],
  "numbers2": [2, 3, 4, 5],
  "id": 45,
  "default": null,
  "checked": false,
  "numbers3": [3, 4, 5],
  "chars1": ["a", "b", "c"],
  "chars2": ["d", "e", "f"]
}
```
file2.json
```json
{
  "setting1": "Another value",
  "setting2": 300,
  "setting3": "none",
  "key2": "value2",
  "numbers1": [1, 2, 3, 4],
  "numbers2": [22, 33, 44, 55],
  "id": null,
  "default": ["value1", "value2"],
  "checked": true,
  "numbers4": [4, 5, 6],
  "chars1": ["a", "b", "c"],
  "chars2": false,
  "obj1": {
    "nestedKey": "value",
    "isNested": true
  }
}
```
Stylish (default):
```
{
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
    numbers1: [1, 2, 3, 4]
  - numbers2: [2, 3, 4, 5]
  + numbers2: [22, 33, 44, 55]
  - numbers3: [3, 4, 5]
  + numbers4: [4, 5, 6]
  + obj1: {nestedKey=value, isNested=true}
  - setting1: Some value
  + setting1: Another value
  - setting2: 200
  + setting2: 300
  - setting3: true
  + setting3: none
}

```

Plain:
```
Property 'chars2' was updated. From [complex value] to false
Property 'checked' was updated. From false to true
Property 'default' was updated. From null to [complex value]
Property 'id' was updated. From 45 to null
Property 'key1' was removed
Property 'key2' was added with value: 'value2'
Property 'numbers2' was updated. From [complex value] to [complex value]
Property 'numbers3' was removed
Property 'numbers4' was added with value: [complex value]
Property 'obj1' was added with value: [complex value]
Property 'setting1' was updated. From 'Some value' to 'Another value'
Property 'setting2' was updated. From 200 to 300
Property 'setting3' was updated. From true to 'none'
```

JSON:
```json
{
  "chars1" : {
    "status" : "unchanged",
    "value" : [ "a", "b", "c" ]
  },
  "chars2" : {
    "status" : "changed",
    "fromValue" : [ "d", "e", "f" ],
    "toValue" : false
  },
  "checked" : {
    "status" : "changed",
    "fromValue" : false,
    "toValue" : true
  },
  "default" : {
    "status" : "changed",
    "fromValue" : null,
    "toValue" : [ "value1", "value2" ]
  },
  "id" : {
    "status" : "changed",
    "fromValue" : 45,
    "toValue" : null
  },
  "key1" : {
    "status" : "removed",
    "value" : "value1"
  },
  "key2" : {
    "status" : "added",
    "value" : "value2"
  },
  "numbers1" : {
    "status" : "unchanged",
    "value" : [ 1, 2, 3, 4 ]
  },
  "numbers2" : {
    "status" : "changed",
    "fromValue" : [ 2, 3, 4, 5 ],
    "toValue" : [ 22, 33, 44, 55 ]
  },
  "numbers3" : {
    "status" : "removed",
    "value" : [ 3, 4, 5 ]
  },
  "numbers4" : {
    "status" : "added",
    "value" : [ 4, 5, 6 ]
  },
  "obj1" : {
    "status" : "added",
    "value" : {
      "nestedKey" : "value",
      "isNested" : true
    }
  },
  "setting1" : {
    "status" : "changed",
    "fromValue" : "Some value",
    "toValue" : "Another value"
  },
  "setting2" : {
    "status" : "changed",
    "fromValue" : 200,
    "toValue" : 300
  },
  "setting3" : {
    "status" : "changed",
    "fromValue" : true,
    "toValue" : "none"
  }
}
```
## Asciinema records:
### Flat files (default - stylish)
Asciinema flat-differ-of-json-files: 
https://asciinema.org/a/LsQTu3eu4AmX9k9PRMXJgdqbM

### Asciinema flat-differ-of-yaml-files: 
https://asciinema.org/a/3zYCTemVJX9x8iGNocukZRq22

### Nested files (default - stylish)
Aciinema nested-stylish-differ: 
https://asciinema.org/a/JnuNgYOjLFu9xYmmomZJxu5yC

### Nested files (plain)
Asciinema nested-plain-differ:
https://asciinema.org/a/lYdalnS5ktneVvcXHQTGPetS0

### Nested files (json)
Asciinema nested-json-differ:
https://asciinema.org/a/eOvUJGpVgBBRLKDhac8AenjGV
