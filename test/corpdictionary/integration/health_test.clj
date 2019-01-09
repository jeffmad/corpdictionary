(ns corpdictionary.integration.health-test
  (:require [clojure.test :refer :all]
            [clj-http.client :as http]
            [cheshire.core :as json]
            [clojure.string :as s]
            [clojure.tools.logging :as log]
            [camel-snake-kebab.core :refer :all]))

(defn read-env []
  (reduce (fn [acc [k v]] (assoc acc (keyword (->kebab-case k)) v)) {} (System/getenv)))

(defn home [env]
  (let [url (str (:base-url env) "/")]
    (http/get url {:throw-exceptions false
                   :socket-timeout 1000
                   :conn-timeout 1000})))

(defn broken [env]
  (let [url (str (:base-url env) "/broken")]
    (http/get url {:throw-exceptions false
                   :socket-timeout 1000
                   :conn-timeout 1000})))

(deftest ^:integration alive-tests
  (testing "is it alive"
    (let [env (read-env)]
      (is (= 200 (:status (home env))))
      (is (= 404 (:status (broken env)))))))
