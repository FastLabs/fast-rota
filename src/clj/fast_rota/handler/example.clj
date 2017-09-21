(ns fast-rota.handler.example
  (:require [compojure.core :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :fast-rota.handler/example [_ options]
  (context "/example" []
    (GET "/" []
      (io/resource "fast_rota/handler/example/example.html"))))
