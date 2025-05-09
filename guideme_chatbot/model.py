####un réseau de neurones à trois couches linéaires 


import torch  
import torch.nn as nn  # Importation des modules de réseau de neurones de PyTorch

# Définition de la classe NeuralNet qui hérite de nn.Module:
class NeuralNet(nn.Module):
    def __init__(self, input_size, hidden_size, num_classes):
        super(NeuralNet, self).__init__() 
        
        # Définition des couches du réseau de neurones
        #qui applique une transformation linéaire aux données d'entrée
        self.l1 = nn.Linear(input_size, hidden_size)  # Couche linéaire de l'entrée à la couche cachée
        self.l2 = nn.Linear(hidden_size, hidden_size)  # Couche linéaire entre deux couches cachées
        self.l3 = nn.Linear(hidden_size, num_classes)  # Couche linéaire de la couche cachée à la sortie
        
        # Fonction d'activation ReLU
        self.relu = nn.ReLU()
    
    # Méthode de propagation avant (forward pass)
    def forward(self, x):
        out = self.l1(x)  # Passage de l'entrée à la première couche linéaire
        out = self.relu(out)  # Application de la fonction d'activation ReLU
        out = self.l2(out)  # Passage de la sortie de la première couche à la deuxième couche linéaire
        out = self.relu(out)  # Application de la fonction d'activation ReLU
        out = self.l3(out)  # Passage de la sortie de la deuxième couche à la couche de sortie
        
        # Pas de fonction d'activation ou de softmax à la fin
        return out


#Le modèle a trois couches linéaires avec ReLU comme fonction d'activation.
#La sortie finale est directement obtenue sans softmax, car la perte de cross-entropy de PyTorch applique déjà softmax en int