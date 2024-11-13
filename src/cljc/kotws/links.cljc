(ns kotws.links
  "Link library that can be automatically checked by the doctor.

  Use `get-url`"
  (:require [kotws.pages :as kpages]
            [kotws.sub-map :as ksubmap]))

(def site-url "" #_"https://caumond.fr/")

(defn add-site [url] (str "https://caumond.fr/" url))

(def ^:private external-links-data
  {:apics "https://www.afrscm.fr/762_p_44059/cpim.html",
   :babashka "https://github.com/babashka/babashka#installation",
   :clever-cloud "https://www.clever-cloud.com/en/",
   :clojure "https://clojure.org",
   :clojurescript "https://clojurescript.org/",
   :clojure-programming
     "https://www.oreilly.com/library/view/clojure-programming/9781449310387/",
   :clean-archi
     "https://www.oreilly.com/library/view/clean-architecture-a/9780134494272/",
   :clean-code
     "https://www.oreilly.com/library/view/clean-code-a/9780136083238/",
   :cor-time-lag
     "https://www.sciencedirect.com/science/article/pii/S0305054806002930",
   :demo-making "https://en.wikipedia.org/wiki/Demoscene",
   :ddd
     "https://www.oreilly.com/library/view/domain-driven-design-tackling/0321125215/",
   :distribution-network
     "https://fr.wikipedia.org/wiki/Algorithme_de_Busacker_et_Gowen",
   :doom-emacs "https://github.com/doomemacs/doomemacs",
   :downstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
   :drp "https://en.wikipedia.org/wiki/Distribution_resource_planning",
   :ejor-transport
     "https://www.sciencedirect.com/science/article/abs/pii/S0377221708004608",
   :flaticon "https://www.flaticon.com/icons",
   :fontawesome "https://fontawesome.com/v4/",
   :git-hub "https://github.com/caumond",
   :hephaistox "https://hephaistox.com",
   :hephaistox-gh "https://github.com/hephaistox",
   :isima
     "https://www.isima.fr/formations/formation-ingenieur/f3-systemes-dinformation-et-aide-a-la-decision/",
   :jewelry-ecommerce
     "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
   :linkedin "http://www.linkedin.com/in/anthony-caumond-a365b15/",
   :make-or-buy-optimization
     "https://www.investopedia.com/terms/m/make-or-buy-decision.asp",
   :malt "http://www.malt.fr/profile/anthonycaumond?overview",
   :phd "https://tel.archives-ouvertes.fr/tel-00713587/document",
   :platform-revolution "https://wwnorton.com/books/Platform-Revolution",
   :plm "https://fr.wikipedia.org/wiki/Gestion_du_cycle_de_vie_(produit)",
   :re-frame "https://github.com/day8/re-frame",
   :reitit "https://github.com/metosin/reitit",
   :ring "https://github.com/ring-clojure/ring",
   :sasu-caumond "https://github.com/caumond/sasucaumond",
   :sasu-societe "https://www.societe.com/societe/caumond-905156402.html",
   :slack "https://clojurians.slack.com/team/U018QDQGZ9Q",
   :seb "https://videos.confluent.io/watch/Uny8xop6vWZut5Hb5CaNpA?",
   :software-purchasing
     "https://www.strategieslogistique.com/Michelin-ameliore-son-S-OP-avec",
   :storrito "http://storrito.com",
   :upstream-ope
     "https://www.usinenouvelle.com/article/michelin-veut-reduire-ses-frais-generaux-de-500-millions-d-euros-d-ici-2020.N396442",
   :w3-css "https://www.w3schools.com/w3css/default.asp",
   :w3-template
     "https://www.w3schools.com/w3css/tryw3css_templates_portfolio.htm",
   :web-caumond-archive
     "https://web.archive.org/web/20060614232036/http:/www.bijouteriecaumond.fr/",
   :togaf "http://caumond.com/docs/togaf.pdf",
   :z80 "https://en.wikipedia.org/wiki/Zilog_Z80"})

(def ^:private image-links-data
  {:apics {:filename "cpim.png"},
   :archi {:filename "archi.png"},
   :anthony {:filename "anthonycaumond.jpg", :alt "Anthony's picture"},
   :babashka {:filename "babashka.png"},
   :bcoo {:filename "bcoo.png"},
   :caumond-resume {:filename "caumond_resume.png"},
   :caumond-cv {:filename "caumond_cv.jpg"},
   :clean-code {:filename "clean_code.jpg"},
   :clean-archi {:filename "clean_architecture.jpg"},
   :clever-cloud {:filename "clever_cloud.svg"},
   :clojure {:filename "clojure.png"},
   :clojure-programming {:filename "clojure_programming.jpg"},
   :clojurescript {:filename "clojurescript.png"},
   :cor-time-lag {:filename "cor_time_lag.png"},
   :distribution-network {:filename "distribution_network.png"},
   :demo-making {:filename "demo_making.png"},
   :doom-emacs {:filename "doom.png"},
   :downstream-ope {:filename "framing.png"},
   :ddd {:filename "ddd_programming.jpg"},
   :drp {:filename "drp.png"},
   :ejor-transport {:filename "ejor_transport.png"},
   :falsestart {:filename "false_start.png"},
   :forge-workshop {:filename "forging.png"},
   :git-hub {:filename "gh.jpeg"},
   :gonogo {:filename "gonogo.png"},
   :hephaistox {:filename "hephaistox_logo.png"},
   :isima {:filename "isima.png"},
   :it {:filename "it.png"},
   :jewelry-ecommerce {:filename "jewelry.png"},
   :kafka {:filename "kafka.png"},
   :make-or-buy-optimization {:filename "make_or_buy.png"},
   :malt {:filename "malt.png"},
   :market-knowledge {:filename "people_network.png"},
   :math {:filename "math.png"},
   :no-image {:filename "no_image.png"},
   :optimization {:filename "optimization.png"},
   :phd {:filename "graduation_cap.png"},
   :platform-revolution {:filename "platform.jpg"},
   :plm-start {:filename "fill_the_gap.png"},
   :plm {:filename "plm_schema.png"},
   :pp {:filename "pp.png"},
   :psa {:filename "psa.png"},
   :re-frame {:filename "re_frame.png"},
   :sasu-caumond {:filename "sasu_caumond.png"},
   :sasu-caumond-dark {:filename "sasu_caumond_dark.png"},
   :sc {:filename "sc.png"},
   :storrito {:filename "storrito.png"},
   :software-purchasing {:filename "software_purchasing.png"},
   :tire {:filename "tires.png"},
   :tissue-tactical-planning {:filename "graduation_cap.png"},
   :teaching {:filename "graduation_cap.png"},
   :upstream-ope {:filename "ope_upstream.jpg"},
   :web-caumond {:filename "web_caumond.png"},
   :z80 {:filename "z80_chipset.png"}})

(def ^:private doc-links-data
  {:caumond-resume {:filename "caumond_resume.pdf"}, ;; Coming from
                                                     ;; https://www.canva.com/design/DAGUsL58eT4/GAwxzsYMR4jqdIo1mRJEaA/edit?utm_content=DAGUsL58eT4&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton
   :caumond-cv {:filename "caumond_cv.pdf"}})

(def external-links
  (-> (map (fn [[link-name external-link]] [link-name
                                            {:url external-link,
                                             :absolute-url external-link,
                                             :target "blank",
                                             :type :external-url}])
           external-links-data)
      (ksubmap/add-key :name)))

(defn img-meta
  [link]
  (when (map? link)
    (let [{:keys [url target alt name], :or {url "images/no_image.png"}} link]
      {:src url, :target target, "linkname" name, :alt alt})))

(defn link-meta
  [link]
  (when (map? link)
    (let [{:keys [url target alt name]} link]
      {:href url, :target target, "link-name" name, :alt alt})))

(defn external-link [kw] (if (keyword? kw) (external-links kw) kw))

(defn a
  ([link content]
   [:a
    (-> link
        link-meta) content])
  ([links kw content]
   [:a
    (-> (get links kw)
        link-meta) content]))

(def image-links
  (-> image-links-data
      (ksubmap/add-key :name)
      (update-vals (fn [{:keys [filename], :as image-link}]
                     (let [url (str site-url "images/" filename)]
                       (assoc image-link
                         :absolute-url (add-site url)
                         :type :image-link
                         :url url))))))

(defn image-link
  "The image `url` matching `kw`"
  [kw]
  (if (keyword? kw) (image-links kw) kw))

(def doc-links
  (-> doc-links-data
      (ksubmap/add-key :name)
      (update-vals (fn [{:keys [filename], :as doc-link}]
                     (let [url (str "docs/" filename)]
                       (assoc doc-link
                         :type :doc-link
                         :absolute-url (add-site url)
                         :url url))))))

(defn doc-link [kw] (if (keyword? kw) (get doc-links kw) kw))

(def route-links
  (-> kpages/pages
      (update-vals (fn [{:keys [url], :as route-link}]
                     (-> route-link
                         (assoc :absolute-url (add-site url)))))))

(defn route-link
  "The route `url` matching `kw`"
  [kw]
  (if (keyword? kw) (get route-links kw) kw))

(def all-links
  (->> [route-links image-links external-links]
       (mapcat vals)
       vec))
