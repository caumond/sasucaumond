(ns kotws.pages.v-coi)

(def stack
  '({:name :clojure
     :img "http://clojure.org/images/clojure-logo-120b.png"
     :href "https://clojure.org"
     :description "As a programming language used by default everywhere in the stack "}
    {:name :spacemacs
     :img "http://spacemacs.org/img/logo.svg"
     :href "https://www.spacemacs.org/"
     :description "As a full IDE integrated with clojure"}
    {:name :leiningen
     :img "https://leiningen.org/img/leiningen.jpg"
     :href "https://leiningen.org/"
     :description "As an integration tool"}
    {:name :cider
     :img "https://cider.mx/img/cider_logo.svg"
     :href "https://docs.cider.mx/cider/index.html"
     :description "To execute code during development phase"}
    {:name :re-agent
     :img "https://github.com/reagent-project/reagent/raw/master/logo/logo-text.png"
     :href "https://github.com/reagent-project/reagent"
     :description "As a web UI provider"}
    {:name :clever-cloud
     :img "https://www.clever-cloud.com/images/brand-assets/logos/v2/logo_on_white.svg"
     :href "https://www.clever-cloud.com/en/"
     :description "As a cloud provider"}
    {:name :log-back
     :img "http://logback.qos.ch/images/logos/lblogo.jpg"
     :href "http://logback.qos.ch/"
     :description "As an implementation for log management"}
    {:name :quartzite
     :img "http://www.quartz-scheduler.org/images/Quartz_Logo_large.jpg"
     :href "https://github.com/michaelklishin/quartzite"
     :description "As a scheduler for everywhere in the stack"}
    {:name :git-lab
     :img "https://assets.gitlab-static.net/assets/illustrations/golden_tanuki-a88ad492b973a0ea6be2316b12aeb3a76ee4e926b3b217dc26d01a57033c9948.svg"
     :href "https://gitlab.com/dashboard/projects"
     :description "As a configuration management system"}
    {:name :see-saw
     :img "https://www.goodfreephotos.com/albums/vector-images/balance-and-seesaw-vector-clipart.png"
     :href "https://github.com/daveray/seesaw"
     :description "To build heavy client-based on swing with clojure and multiplatform power"}
    ))

(defn coi-panel[]
  [:div {:class "w3-row-padding"}
   [:h1 "My current prefered stack is:"]
   (for [elt stack]
     [:div {:class "w3-third"}
      [:a {:id "coi-item" :class "w3-white w3-center w3-card" :href (:href elt)}
       [:h2 {:class "w3-margin-bottom"} (:name elt)]
       [:img.coi-image {:src (:img elt) :class "w3-margin-bottom"}]
       [:p {:class "card-text-ellipsis w3-padding-large"}
        (:description elt)]
       ]]
     )
   ]
  )
