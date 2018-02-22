(ns leiningen.kotlinc
  (:require [leiningen.core.project :refer [merge-profiles]]
            [leiningen.core.eval :refer [eval-in-project]]
            [leiningen.core.main :refer [info]]
            [clojure.string :as s]
            )
  )

(defn kotlin-profile [version]
  {:dependencies [['org.jetbrains.kotlin/kotlin-compiler version]]})

(defn kotlinc
  "Compile kotlin source files from :kotlin-source-paths. Remember to add
   a dependency on kotlin-runtime to your project!"
  [project & args]
  (let [settings (:lein-kotlinc project)
        version (or (:kotlin-compiler-version settings) "0.12.1230")
        project (merge-profiles project [(kotlin-profile version)])
        {kotlin-source-path :kotlin-source-path
         compile-path :compile-path} project]

    (cond
      (nil? kotlin-source-path) (info ":kotlin-source-path not defined; no kotlin files will be compiled")
      :otherwise (eval-in-project project
                  `(do
                    (org.jetbrains.kotlin.cli.jvm.K2JVMCompiler/main
                      (into-array ["-d" ~compile-path
                                   ~kotlin-source-path ])))))))
