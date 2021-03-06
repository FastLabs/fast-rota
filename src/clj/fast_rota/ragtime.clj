(ns fast-rota.ragtime
  (:require [integrant.core :as ig]
            [ragtime.jdbc :as rag-jdbc]
            [ragtime.core :as ragtime]
            [clojure.string :as str]
            [ragtime.repl :as rag-repl]))

(defn- update-migration-id [{:keys [id] :as migration}]
  (assoc migration :id (str/replace id #".*/" "")))

(defmethod ig/init-key :fast-rota/ragtime
  [_ [path]]
  (->> (rag-jdbc/load-resources path)
       (map update-migration-id)
       (map rag-jdbc/sql-migration)))




