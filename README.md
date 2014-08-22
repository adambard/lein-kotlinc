# kotlinc

Compile Kotlin files in your Leiningen project

This is very alpha; use at your own risk.

## Usage

First, add `lein-kotlinc` to your `:plugins` setting in `project.clj`:

```clojure
:plugins [[lein-kotlinc "0.1.0"]]
```

Then, set your `:kotlin-source-path` settings:

```clojure
:kotlin-source-path "src/kt"
```

Finally, if you want to actually run any Kotlin code, include
`kotlin-runtime` as a dependency:

```clojure
[org.jetbrains.kotlin/kotlin-runtime "0.8.679"]
```

Then, you can compile your kotlin files any time, using `lein kotlinc`

```
$ lein kotlinc
```

## License

Copyright © 2014 Adam Bard (adambard.com)

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
