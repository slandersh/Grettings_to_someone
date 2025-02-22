class ConfettiManager {
    constructor() {
        this.colors = ['#ff69b4', '#4a90e2', '#ffeb3b', '#ff5252', '#66bb6a'];
        this.confettiContainer = document.querySelector('.confetti-container');
    }

    createConfetti() {
        const confetti = document.createElement('div');
        const color = this.colors[Math.floor(Math.random() * this.colors.length)];
        
        confetti.style.cssText = `
            position: absolute;
            width: 10px;
            height: 10px;
            background: ${color};
            left: ${Math.random() * 100}vw;
            animation: fall 3s linear forwards;
        `;
        
        this.confettiContainer.appendChild(confetti);
        
        setTimeout(() => {
            confetti.remove();
        }, 3000);
    }

    startCelebration() {
        for (let i = 0; i < 50; i++) {
            setTimeout(() => {
                this.createConfetti();
            }, i * 100);
        }
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const confettiManager = new ConfettiManager();
    const celebrationButton = document.querySelector('.celebration-button');
    
    celebrationButton.addEventListener('click', () => {
        confettiManager.startCelebration();
    });
});
